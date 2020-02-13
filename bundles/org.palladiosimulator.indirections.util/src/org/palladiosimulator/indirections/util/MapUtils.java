package org.palladiosimulator.indirections.util;

import java.util.Map;
import java.util.Optional;

public final class MapUtils {
    private MapUtils() {
    }

    public static <K, V> Optional<V> tryGet(Map<K, V> map, K key) {
        return Optional.ofNullable(map.get(key));
    }

    public static <K, V> V claim(Map<K, V> map, K key) {
        if (!map.containsKey(key))
            throw new IllegalStateException(
                    "It was claimed that the map contains the key " + key + ", but it does not.");

        return map.get(key);
    }
}
