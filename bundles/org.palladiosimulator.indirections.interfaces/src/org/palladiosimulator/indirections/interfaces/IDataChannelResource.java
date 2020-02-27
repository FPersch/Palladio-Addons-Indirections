package org.palladiosimulator.indirections.interfaces;

import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IDataChannelResource {
	boolean put(ISchedulableProcess process, DataChannelSourceConnector sourceConnector,
			IndirectionDate date);

	/**
	 * Name of the resource.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Unique identifier of the resource.
	 * 
	 * @return
	 */
	String getId();

	void spinOnce(ISchedulableProcess schedulableProcess);
}
