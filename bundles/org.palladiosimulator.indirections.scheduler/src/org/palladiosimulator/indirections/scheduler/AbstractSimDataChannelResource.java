package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.scheduler.OpenWorkloadUserWithStackFactory.OpenWorkloadUserWithStack;
import org.palladiosimulator.indirections.scheduler.calculators.ContextAwareTimeSpanCalculator;
import org.palladiosimulator.indirections.scheduler.calculators.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.scheduler.scheduling.SuspendableSchedulerEntity;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.MapUtils;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractSimDataChannelResource implements IDataChannelResource {
    protected Map<DataChannelSinkConnector, IndirectionQueue<ProcessWaitingToConsume>> outgoingQueues;
    protected Map<DataChannelSourceConnector, IndirectionQueue<ProcessWaitingToEmit>> incomingQueues;
    protected DataChannel dataChannel;

    protected final InterpreterDefaultContext context;
    protected SimuComModel model;

    protected final String name;
    protected final String id;
    protected final int capacity;

    protected class IndirectionQueue<T extends SuspendableSchedulerEntity> {
        public final Queue<IndirectionDate> elements;
        public final Queue<T> processes;

        public IndirectionQueue() {
            this.elements = new ArrayDeque<>();
            this.processes = new ArrayDeque<>();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public AbstractSimDataChannelResource(final DataChannel dataChannel, InterpreterDefaultContext context,
            final SchedulerModel model) {
        if (!(model instanceof SimuComModel)) {
            throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
                    + model.getClass().getName());
        }

        this.dataChannel = dataChannel;

        this.id = dataChannel.getId() + "_" + UUID.randomUUID().toString();
        this.name = dataChannel.getEntityName() + "_" + this.getClass().getSimpleName();

        this.capacity = dataChannel.getCapacity();

        this.model = (SimuComModel) model;
        this.context = context;

        this.initializeQueues();
        this.createPushingUserFactories();
        this.setupCalculators();
    }

    private ContextAwareTimeSpanCalculator<ProcessWaitingToConsume> waitingToGetTimeCalculator;
    private ContextAwareTimeSpanCalculator<ProcessWaitingToEmit> waitingToPutTimeCalculator;
    private TriggerableTimeSpanCalculator afterAcceptingAgeCalculator;
    private TriggerableTimeSpanCalculator beforeEmittingAgeCalculator;

    private void setupCalculators() {
        this.waitingToGetTimeCalculator = new ContextAwareTimeSpanCalculator<>("Waiting time to get from " + name,
                MetricDescriptionConstants.WAITING_TIME_METRIC, MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE,
                context);
        this.waitingToPutTimeCalculator = new ContextAwareTimeSpanCalculator<>("Waiting time to put to " + name,
                MetricDescriptionConstants.WAITING_TIME_METRIC, MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE,
                context);
        this.afterAcceptingAgeCalculator = new TriggerableTimeSpanCalculator(
                "Data age after accepting date (" + name + ")", IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
        this.beforeEmittingAgeCalculator = new TriggerableTimeSpanCalculator("Data age before emitting (" + name + ")",
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
    }

    private void initializeQueues() {
        this.outgoingQueues = this.dataChannel.getDataChannelSinkConnector().stream()
                .filter(it -> !it.getDataSinkRole().isPushing())
                .collect(Collectors.toMap(Function.identity(), it -> new IndirectionQueue<ProcessWaitingToConsume>()));

        this.incomingQueues = this.dataChannel.getDataChannelSourceConnector().stream()
                .collect(Collectors.toMap(Function.identity(), it -> new IndirectionQueue<ProcessWaitingToEmit>()));
    }

    protected void processDataAvailableToGet() {
        for (DataChannelSinkConnector sinkConnector : dataChannel.getDataChannelSinkConnector()) {
            if (sinkConnector.getDataSinkRole().isPushing()) {
                spawnNewProcessThatTakesFromConnector(sinkConnector);
            } else {
                notifyProcessesWaitingToGetFromQueue(outgoingQueues.get(sinkConnector));
            }
        }
    }

    private Map<DataChannelSinkConnector, OpenWorkloadUserWithStackFactory> sinkConnectorToUserFactory;

    private void createPushingUserFactories() {
        if (sinkConnectorToUserFactory != null) {
            throw new IllegalStateException(
                    "User factories already populated (" + sinkConnectorToUserFactory.values().size() + " present).");
        }

        sinkConnectorToUserFactory = this.dataChannel.getDataChannelSinkConnector().stream().collect(Collectors.toMap(
                Function.identity(), it -> OpenWorkloadUserWithStackFactory.createPushingUserFactory(it, model)));
    }

    private void spawnNewProcessThatTakesFromConnector(DataChannelSinkConnector sinkConnector) {
        OpenWorkloadUserWithStack user = MapUtils.claim(sinkConnectorToUserFactory, sinkConnector).createUser();

        // creates a new process. the data is set to the new process when the process is activated
        // in the next step.
        ProcessWaitingToConsume consumerProcess = new ProcessWaitingToConsume(model, user, sinkConnector, date -> {
            user.setDataAndStartUserLife(IndirectionSimulationUtil
                    .getOneParameter(sinkConnector.getDataSinkRole().getEventGroup()).getParameterName(), date,
                    context);
        });

        allowToGetAndActivate(consumerProcess);
    }

    private void notifyProcessesWaitingToGetFromQueue(IndirectionQueue<ProcessWaitingToConsume> queue) {
        ProcessWaitingToConsume waitingProcess = queue.processes.peek();
        while (waitingProcess != null && canProceedToGet(waitingProcess)) {
            allowToGetAndActivate(waitingProcess);
            notifyProcessesWaitingToPut();
            queue.processes.remove();
            waitingProcess = queue.processes.peek();
        }
    }

    protected void notifyProcessesWaitingToPut() {
        for (final IndirectionQueue<ProcessWaitingToEmit> queue : this.incomingQueues.values()) {
            ProcessWaitingToEmit waitingProcess = queue.processes.peek();
            while (waitingProcess != null && canProceedToPut(waitingProcess)) {
                allowToPutAndActivate(waitingProcess);
                processDataAvailableToGet();
                queue.processes.remove();
                waitingProcess = queue.processes.peek();
            }
        }
    }

    @Override
    public boolean put(final ISchedulableProcess schedulableProcess, final DataChannelSourceConnector sourceConnector,
            final IndirectionDate date) {
        IndirectionSimulationUtil.validateIndirectionDateStructure(date,
                sourceConnector.getDataSourceRole().getEventGroup());

        if (!this.model.getSimulationControl().isRunning()) {
            return true;
        }

        final ProcessWaitingToEmit process = new ProcessWaitingToEmit(this.model, schedulableProcess, sourceConnector,
                date);

        this.waitingToPutTimeCalculator.startMeasurement(process);

        if (this.canProceedToPut(process)) {
            this.allowToPutAndActivate(process);
            this.processDataAvailableToGet();
            return true;
        } else {
            this.incomingQueues.get(sourceConnector).processes.add(process);
            process.passivate();
            return false;
        }
    }

    @Override
    public boolean get(final ISchedulableProcess schedulableProcess, final DataChannelSinkConnector sinkConnector,
            final Consumer<IndirectionDate> callback) {
        if (!this.model.getSimulationControl().isRunning()) {
            return true;
        }

        if (sinkConnector.getDataSinkRole().isPushing()) {
            throw new IllegalStateException("Cannot pull data over pushing connector " + sinkConnector.toString()
                    + ", SinkRole: " + sinkConnector.getDataSinkRole().toString());
        }

        final ProcessWaitingToConsume process = new ProcessWaitingToConsume(this.model, schedulableProcess,
                sinkConnector, callback);

        this.waitingToGetTimeCalculator.startMeasurement(process);

        if (this.canProceedToGet(process)) {
            this.allowToGetAndActivate(process);
            this.notifyProcessesWaitingToPut();
            return true;
        } else {
            this.outgoingQueues.get(sinkConnector).processes.add(process);
            process.passivate();
            return false;
        }
    }

    private void activateIfWaiting(SuspendableSchedulerEntity process) {
        if (process.isWaiting()) {
            process.activate();
        }
    }

    private boolean canProceedToPut(final ProcessWaitingToEmit process) {
        final Queue<ProcessWaitingToEmit> waitingToPutQueue = this.incomingQueues
                .get(process.sourceConnector).processes;
        final boolean isNextProcess = waitingToPutQueue.isEmpty()
                || waitingToPutQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && canAcceptDataFrom(process.sourceConnector);
    }

    protected abstract boolean canAcceptDataFrom(DataChannelSourceConnector sourceConnector);

    protected abstract boolean canProvideDataFor(DataChannelSinkConnector sinkConnector);

    private boolean canProceedToGet(final ProcessWaitingToConsume process) {
        final Queue<ProcessWaitingToConsume> waitingToGetQueue = this.outgoingQueues
                .get(process.sinkConnector).processes;
        final boolean isNextProcess = waitingToGetQueue.isEmpty()
                || waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && canProvideDataFor(process.sinkConnector);
    }

    protected abstract Iterable<IndirectionDate> provideDataFor(DataChannelSinkConnector sinkConnector);

    protected abstract void acceptDataFrom(DataChannelSourceConnector sourceConnector, IndirectionDate date);

    private void allowToGetAndActivate(ProcessWaitingToConsume process) {
        this.waitingToGetTimeCalculator.endMeasurement(process);

        Iterable<IndirectionDate> dataToEmit = this.provideDataFor(process.sinkConnector);
        for (IndirectionDate dateToEmit : dataToEmit) {
            IndirectionSimulationUtil.getDataAgeRecursive(dateToEmit)
                    .forEach(beforeEmittingAgeCalculator::doMeasureUntilNow);
            process.callback.accept(dateToEmit);
        }
        activateIfWaiting(process);
    }

    private void allowToPutAndActivate(ProcessWaitingToEmit process) {
        this.waitingToPutTimeCalculator.endMeasurement(process);

        acceptDataFrom(process.sourceConnector, process.date);

        IndirectionSimulationUtil.getDataAgeRecursive(process.date)
                .forEach(afterAcceptingAgeCalculator::doMeasureUntilNow);

        activateIfWaiting(process);
    }

    protected String getOutgoingParameterName() {
        return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSourceEventGroup()).getParameterName();
    }

    protected String getIncomingParameterName() {
        return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSinkEventGroup()).getParameterName();
    }
}
