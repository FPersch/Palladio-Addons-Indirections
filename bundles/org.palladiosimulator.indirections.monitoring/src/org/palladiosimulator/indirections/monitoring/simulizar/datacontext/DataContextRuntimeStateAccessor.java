package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import org.palladiosimulator.simulizar.runtimestate.AbstractSimuLizarRuntimeState;
import org.palladiosimulator.simulizar.runtimestate.IRuntimeStateAccessor;

public class DataContextRuntimeStateAccessor implements IRuntimeStateAccessor {

	public DataContextRuntimeStateAccessor() {
	}
	
	@Override
	public void setRuntimeStateModel(AbstractSimuLizarRuntimeState state) {
		state.getEventNotificationHelper().addObserver(new DataContextProbeFrameworkListener(state.getPCMPartitionManager(), state.getModel()));
	}

}
