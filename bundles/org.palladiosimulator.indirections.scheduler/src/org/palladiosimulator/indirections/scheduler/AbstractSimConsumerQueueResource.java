package org.palladiosimulator.indirections.scheduler;

import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.interfaces.IConsumerQueueResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.scheduler.OpenWorkloadUserWithStackFactory.OpenWorkloadUserWithStack;
import org.palladiosimulator.indirections.scheduler.calculators.ContextAwareTimeSpanCalculator;
import org.palladiosimulator.indirections.scheduler.calculators.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToConsume;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.util.MapUtils;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractSimConsumerQueueResource implements IConsumerQueueResource {
    protected Map<ConsumerQueueSinkConnector, IndirectionQueue<ProcessWaitingToConsume>> outgoingQueues;
    protected ConsumerQueue consumerQueue;

    protected final InterpreterDefaultContext context;
    protected SimuComModel model;

    protected final String name;
    protected final String id;
    protected final int capacity;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public AbstractSimConsumerQueueResource(final ConsumerQueue consumerQueue, InterpreterDefaultContext context,
            final SchedulerModel model) {
        if (!(model instanceof SimuComModel)) {
            throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
                    + model.getClass().getName());
        }

        this.consumerQueue = consumerQueue;

        this.id = consumerQueue.getId() + "_" + UUID.randomUUID().toString();
        this.name = consumerQueue.getEntityName() + "_" + this.getClass().getSimpleName();

        this.capacity = consumerQueue.getCapacity();

        this.model = (SimuComModel) model;
        this.context = context;

        this.initializeQueues();
        this.createPushingUserFactories();
        this.setupCalculators();
    }

    private ContextAwareTimeSpanCalculator<ProcessWaitingToConsume> waitingToGetTimeCalculator;
    private TriggerableTimeSpanCalculator beforeEmittingAgeCalculator;

    private void setupCalculators() {
        this.waitingToGetTimeCalculator = new ContextAwareTimeSpanCalculator<>("Waiting time to get from " + name,
                MetricDescriptionConstants.WAITING_TIME_METRIC, MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE,
                context);
        this.beforeEmittingAgeCalculator = new TriggerableTimeSpanCalculator("Data age before emitting (" + name + ")",
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
    }

    private void initializeQueues() {
        this.outgoingQueues = this.consumerQueue.getSinkConnector().stream()
                .filter(it -> !it.getDataSinkRole().isPushing())
                .collect(Collectors.toMap(Function.identity(), it -> new IndirectionQueue<ProcessWaitingToConsume>()));
    }

    protected void processDataAvailableToGet() {
        for (ConsumerQueueSinkConnector sinkConnector : consumerQueue.getSinkConnector()) {
            if (sinkConnector.getDataSinkRole().isPushing()) {
                spawnNewProcessThatTakesFromConnector(sinkConnector);
            } else {
                notifyProcessesWaitingToGetFromQueue(outgoingQueues.get(sinkConnector));
            }
        }
    }

    private Map<ConsumerQueueSinkConnector, OpenWorkloadUserWithStackFactory> sinkConnectorToUserFactory;

    private void createPushingUserFactories() {
        if (sinkConnectorToUserFactory != null) {
            throw new IllegalStateException(
                    "User factories already populated (" + sinkConnectorToUserFactory.values().size() + " present).");
        }

        sinkConnectorToUserFactory = this.consumerQueue.getSinkConnector().stream().collect(Collectors.toMap(
                Function.identity(), it -> OpenWorkloadUserWithStackFactory.createPushingUserFactory(it, model)));
    }

    private void spawnNewProcessThatTakesFromConnector(ConsumerQueueSinkConnector sinkConnector) {
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

    @Override
    public boolean get(final ISchedulableProcess schedulableProcess, final ConsumerQueueSinkConnector sinkConnector,
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

    private void notifyProcessesWaitingToPut() {
        throw new UnsupportedOperationException();
    }

    protected abstract boolean canProvideDataFor(ConsumerQueueSinkConnector sinkConnector);

    private boolean canProceedToGet(final ProcessWaitingToConsume process) {
        final Queue<ProcessWaitingToConsume> waitingToGetQueue = this.outgoingQueues
                .get(process.sinkConnector).processes;
        final boolean isNextProcess = waitingToGetQueue.isEmpty()
                || waitingToGetQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && canProvideDataFor(process.sinkConnector);
    }

    protected abstract Iterable<IndirectionDate> provideDataFor(ConsumerQueueSinkConnector sinkConnector);

    private void allowToGetAndActivate(ProcessWaitingToConsume process) {
        this.waitingToGetTimeCalculator.endMeasurement(process);

        Iterable<IndirectionDate> dataToEmit = this.provideDataFor(process.sinkConnector);
        for (IndirectionDate dateToEmit : dataToEmit) {
            IndirectionSimulationUtil.getDataAgeRecursive(dateToEmit)
                    .forEach(beforeEmittingAgeCalculator::doMeasureUntilNow);
            process.callback.accept(dateToEmit);
        }

        IndirectionSimulationUtil.activateIfWaiting(process);
    }

    protected String getOutgoingParameterName() {
        return IndirectionSimulationUtil.getOneParameter(this.consumerQueue.getSourceEventGroup()).getParameterName();
    }

    protected String getIncomingParameterName() {
        return IndirectionSimulationUtil.getOneParameter(this.consumerQueue.getSinkEventGroup()).getParameterName();
    }
}
