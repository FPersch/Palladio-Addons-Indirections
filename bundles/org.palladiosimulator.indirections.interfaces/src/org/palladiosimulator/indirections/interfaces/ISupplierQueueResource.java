package org.palladiosimulator.indirections.interfaces;

import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface ISupplierQueueResource {
    public boolean put(ISchedulableProcess process, SupplierQueueSourceConnector sourceConnector, IndirectionDate date);

    /**
     * Name of the resource.
     * 
     * @return
     */
    public String getName();

    /**
     * Unique identifier of the resource.
     * 
     * @return
     */
    public String getId();
}
