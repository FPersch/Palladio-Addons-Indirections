package org.palladiosimulator.indirections.scheduler.rewrite;

import java.util.Collection;
import java.util.Optional;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;

public class SimQueue implements SimStatefulResource {
	@Override
	public void onDataArrive(DataSinkRole sinkRole) {
		
	}
	
	@Override
	public void onActivate(DataSourceRole sourceRole) {
		
	}

	@Override
	public SimFuture<Optional<IndirectionDate>> getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimFuture<Optional<IndirectionDate>> flushElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimFuture<Optional<Collection<IndirectionDate>>> flushGroup() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
