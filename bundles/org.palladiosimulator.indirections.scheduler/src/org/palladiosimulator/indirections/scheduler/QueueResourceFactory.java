package org.palladiosimulator.indirections.scheduler;

import org.palladiosimulator.indirections.interfaces.IConsumerQueueResource;
import org.palladiosimulator.indirections.interfaces.IQueueResourceFactory;
import org.palladiosimulator.indirections.interfaces.ISupplierQueueResource;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;

public class QueueResourceFactory implements IQueueResourceFactory {

    @Override
    public IConsumerQueueResource createConsumerQueueResource(ConsumerQueue consumerQueue,
            InterpreterDefaultContext context, SchedulerModel model) {
        return new SimConsumerQueueResource(consumerQueue, context, model);
    }

    @Override
    public ISupplierQueueResource createSupplierQueueResource(SupplierQueue supplierQueue,
            InterpreterDefaultContext context, SchedulerModel model) {
        return new SimSupplierQueueResource(supplierQueue, context, model);
    }

}
