package org.palladiosimulator.indirections.scheduler.scheduling;

import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToConsume extends SuspendableSchedulerEntity {
    public final Consumer<IndirectionDate> callback;
    public final ConsumerQueueSinkConnector sinkConnector;

    public ProcessWaitingToConsume(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final ConsumerQueueSinkConnector sinkConnector, final Consumer<IndirectionDate> callback) {
        super(model, schedulableProcess, ProcessWaitingToConsume.class.getName());

        this.callback = callback;
        this.sinkConnector = sinkConnector;
    }

}