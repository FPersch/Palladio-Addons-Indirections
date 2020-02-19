package org.palladiosimulator.indirections.interfaces;

import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface IQueueResourceFactory {
    public IConsumerQueueResource createConsumerQueueResource(ConsumerQueue consumerQueue,
            InterpreterDefaultContext context, final SchedulerModel model);

    public ISupplierQueueResource createSupplierQueueResource(SupplierQueue supplierQueue,
            InterpreterDefaultContext context, final SchedulerModel model);
}
