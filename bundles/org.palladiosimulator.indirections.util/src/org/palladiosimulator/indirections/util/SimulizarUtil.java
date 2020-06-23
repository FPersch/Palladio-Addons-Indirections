package org.palladiosimulator.indirections.util;

import org.palladiosimulator.simulizar.simulationevents.PeriodicallyTriggeredSimulationEntity;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public final class SimulizarUtil {
	public static PeriodicallyTriggeredSimulationEntity schedulePeriodically(SimuComModel simuComModel,
			double firstOccurrence, double delay, Runnable process) {
		return new PeriodicallyTriggeredSimulationEntity(simuComModel, firstOccurrence, delay) {
			@Override
			protected void triggerInternal() {
				process.run();
			}
		};
	}

	public static PeriodicallyTriggeredSimulationEntity schedulePeriodicallyAndRuneOnceInitially(
			SimuComModel simuComModel, double firstOccurrence, double delay, Runnable process) {
		process.run();
		return schedulePeriodically(simuComModel, firstOccurrence, delay, process);
	}

	public static PeriodicallyTriggeredSimulationEntity schedulePeriodicallyInTimeInterval(SimuComModel simuComModel,
			double start, double end, double delay, Runnable process) {
		return new PeriodicallyTriggeredSimulationEntity(simuComModel, start, delay) {
			@Override
			protected void triggerInternal() {
				if (getModel().getSimulationControl().getCurrentSimulationTime() > end) {
					stopScheduling();
					return;
				}
				process.run();
			}
		};
	}

	public static FireOnceSimulationEntity scheduleOnce(SimuComModel simuComModel, double delay, Runnable process) {
		return new FireOnceSimulationEntity(simuComModel, delay, process);
	}
}
