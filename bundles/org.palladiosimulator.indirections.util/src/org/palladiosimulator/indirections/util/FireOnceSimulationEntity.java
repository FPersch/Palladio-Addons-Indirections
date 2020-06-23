package org.palladiosimulator.indirections.util;

import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * A one shot simulation entity that can be schedule at a specific point of time.
 * @author Dominik Werle
 *
 */
public class FireOnceSimulationEntity extends PeriodicallyTriggeredSimulationEntity {
	private final Runnable routine;
	private boolean hasRun = false;

	public FireOnceSimulationEntity(SimuComModel model, double delay, Runnable routine) {
		// 10000 could be any number, since it is cancelled afert is has run
		super(model, delay, 10000);
		this.routine = routine;
	}

	@Override
	public void setDelayAndReinitialize(double nextOccurrence, double delay) {
		throw new UnsupportedOperationException();
	}
	
	protected final void triggerInternal() {
		if (!hasRun) {
			routine.run();
			hasRun = true;
			removeEvent();
		}
	}
}
