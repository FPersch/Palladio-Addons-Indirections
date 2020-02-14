package org.palladiosimulator.indirections.scheduler;

import org.apache.log4j.Logger;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimSupplierQueueResource extends AbstractSimSupplierQueueResource {
    private static final Logger LOGGER = Logger.getLogger(SimSupplierQueueResource.class);

    public SimSupplierQueueResource(SupplierQueue supplierQueue, InterpreterDefaultContext context,
            SchedulerModel model) {
        super(supplierQueue, context, model);

        if (!(model instanceof SimuComModel)) {
            throw new PCMModelInterpreterException("Unsupported type of model: " + model.getClass().getName()
                    + ", expected: " + SimuComModel.class.getName());
        }

        SimuComModel simuComModel = (SimuComModel) model;
    }

    @Override
    protected void acceptDataFrom(SupplierQueueSourceConnector sourceConnector, IndirectionDate date) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean canAcceptDataFrom(SupplierQueueSourceConnector sourceConnector) {
        return true;
    }
}
