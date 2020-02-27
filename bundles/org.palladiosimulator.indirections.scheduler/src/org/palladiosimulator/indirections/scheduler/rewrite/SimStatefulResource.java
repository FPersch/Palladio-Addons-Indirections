package org.palladiosimulator.indirections.scheduler.rewrite;

import java.util.Collection;
import java.util.Optional;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;

public interface SimStatefulResource {
	void onDataArrive(DataSinkRole sinkRole);
	void onActivate(DataSourceRole sourceRole);
	
	SimFuture<Optional<IndirectionDate>> getElement();
	SimFuture<Optional<IndirectionDate>> flushElements();
	
	SimFuture<Optional<Collection<IndirectionDate>>> flushGroup();
}
