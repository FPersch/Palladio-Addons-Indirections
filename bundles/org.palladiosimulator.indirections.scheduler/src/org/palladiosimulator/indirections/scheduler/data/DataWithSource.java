package org.palladiosimulator.indirections.scheduler.data;

import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class DataWithSource<T extends IndirectionDate> {
    public final QueueConnector source;
    public final T date;

    public DataWithSource(QueueConnector source, T date) {
        super();
        this.source = source;
        this.date = date;
    }
}