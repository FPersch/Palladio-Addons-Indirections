package org.palladiosimulator.indirections.scheduler.data;

import org.palladiosimulator.indirections.composition.DataChannelConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class DataWithSource<T extends IndirectionDate> {
    public final DataChannelConnector source;
    public final T date;

    public DataWithSource(DataChannelConnector source, T date) {
        super();
        this.source = source;
        this.date = date;
    }
}