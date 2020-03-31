package org.palladiosimulator.indirections.scheduler.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;

public class ConcreteIndirectionDate implements IndirectionDate {
    private final Map<String, Object> data;
    private final double time;
    public final UUID uuid = UUID.randomUUID();

    public ConcreteIndirectionDate(Map<String, Object> data, double time) {
        this.data = new HashMap<>(data);
        this.time = time;
    }

    @Override
    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public Double getTime() {
        return time;
    }

    @Override
    public String toString() {
        String dataToString = data.entrySet().stream().map(it -> it.getKey() + "->" + it.getValue())
                .collect(Collectors.joining(","));
        return "<" + this.getClass().getSimpleName() + " (" + uuid + "): " + dataToString + ">";
    }

	@Override
	public void addDate(String key, Object value) {
		data.put(key, value);
	}
}
