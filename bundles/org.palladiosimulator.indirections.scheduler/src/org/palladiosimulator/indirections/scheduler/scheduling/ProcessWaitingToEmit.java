package org.palladiosimulator.indirections.scheduler.scheduling;

import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class ProcessWaitingToEmit extends SuspendableSchedulerEntity {
    public final IndirectionDate date;
    public final SupplierQueueSourceConnector sourceConnector;

    public ProcessWaitingToEmit(final SchedulerModel model, final ISchedulableProcess schedulableProcess,
            final SupplierQueueSourceConnector sourceConnector, final IndirectionDate frame) {
        super(model, schedulableProcess, ProcessWaitingToEmit.class.getName());

        this.date = frame;
        this.sourceConnector = sourceConnector;
    }
}