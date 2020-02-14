package org.palladiosimulator.indirections.interfaces;

import java.util.function.Consumer;

import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IConsumerQueueResource {
    public abstract boolean get(ISchedulableProcess process, ConsumerQueueSinkConnector sinkConnector,
            Consumer<IndirectionDate> callback);

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
