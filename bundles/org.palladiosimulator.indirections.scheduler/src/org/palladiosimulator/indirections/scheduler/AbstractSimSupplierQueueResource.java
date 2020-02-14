package org.palladiosimulator.indirections.scheduler;

import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.indirections.interfaces.ISupplierQueueResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.scheduler.calculators.ContextAwareTimeSpanCalculator;
import org.palladiosimulator.indirections.scheduler.calculators.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.scheduler.scheduling.ProcessWaitingToEmit;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class AbstractSimSupplierQueueResource implements ISupplierQueueResource {
    protected SupplierQueue supplierQueue;

    protected final InterpreterDefaultContext context;
    protected SimuComModel model;

    protected final String name;
    protected final String id;

    protected Map<SupplierQueueSourceConnector, IndirectionQueue<ProcessWaitingToEmit>> incomingQueues;

    public AbstractSimSupplierQueueResource(final SupplierQueue supplierQueue, InterpreterDefaultContext context,
            final SchedulerModel model) {
        if (!(model instanceof SimuComModel)) {
            throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
                    + model.getClass().getName());
        }

        this.supplierQueue = supplierQueue;

        this.id = supplierQueue.getId() + "_" + UUID.randomUUID().toString();
        this.name = supplierQueue.getEntityName() + "_" + this.getClass().getSimpleName();

        this.model = (SimuComModel) model;
        this.context = context;

        initializeInternalQueues();
        setupCalculators();
    }

    private ContextAwareTimeSpanCalculator<ProcessWaitingToEmit> waitingToPutTimeCalculator;
    private TriggerableTimeSpanCalculator afterAcceptingAgeCalculator;

    private void setupCalculators() {
        this.waitingToPutTimeCalculator = new ContextAwareTimeSpanCalculator<>("Waiting time to put to " + name,
                MetricDescriptionConstants.WAITING_TIME_METRIC, MetricDescriptionConstants.WAITING_TIME_METRIC_TUPLE,
                context);
        this.afterAcceptingAgeCalculator = new TriggerableTimeSpanCalculator(
                "Data age after accepting date (" + name + ")", IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
    }

    private void initializeInternalQueues() {
        this.incomingQueues = this.supplierQueue.getSourceConnector().stream()
                .collect(Collectors.toMap(Function.identity(), it -> new IndirectionQueue<ProcessWaitingToEmit>()));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean put(final ISchedulableProcess schedulableProcess, final SupplierQueueSourceConnector sourceConnector,
            final IndirectionDate date) {

        throw new UnsupportedOperationException();

        /*
         * IndirectionSimulationUtil.validateIndirectionDateStructure(date,
         * sourceConnector.getDataSourceRole().getEventGroup());
         * 
         * if (!this.model.getSimulationControl().isRunning()) { return true; }
         * 
         * final ProcessWaitingToEmit process = new ProcessWaitingToEmit(this.model,
         * schedulableProcess, sourceConnector, date);
         * 
         * this.waitingToPutTimeCalculator.startMeasurement(process);
         * 
         * if (this.canProceedToPut(process)) { this.allowToPutAndActivate(process);
         * this.processDataAvailableToGet(); return true; } else {
         * this.incomingQueues.get(sourceConnector).processes.add(process); process.passivate();
         * return false; }
         */
    }

    private boolean canProceedToPut(final ProcessWaitingToEmit process) {
        final Queue<ProcessWaitingToEmit> waitingToPutQueue = this.incomingQueues
                .get(process.sourceConnector).processes;
        final boolean isNextProcess = waitingToPutQueue.isEmpty()
                || waitingToPutQueue.peek().schedulableProcess.equals(process.schedulableProcess);

        return isNextProcess && canAcceptDataFrom(process.sourceConnector);
    }

    protected abstract boolean canAcceptDataFrom(SupplierQueueSourceConnector sourceConnector);

    private void allowToPutAndActivate(ProcessWaitingToEmit process) {
        this.waitingToPutTimeCalculator.endMeasurement(process);

        acceptDataFrom(process.sourceConnector, process.date);

        IndirectionSimulationUtil.getDataAgeRecursive(process.date)
                .forEach(afterAcceptingAgeCalculator::doMeasureUntilNow);

        IndirectionSimulationUtil.activateIfWaiting(process);
    }

    protected abstract void acceptDataFrom(SupplierQueueSourceConnector sourceConnector, IndirectionDate date);

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

    private void processDataAvailableToGet() {
        throw new UnsupportedOperationException();
    }
}
