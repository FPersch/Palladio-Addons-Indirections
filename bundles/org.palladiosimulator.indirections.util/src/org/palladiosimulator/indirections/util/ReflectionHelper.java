package org.palladiosimulator.indirections.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class ReflectionHelper {
	public static <T, C> void setFinalField(C object, Class<C> clazz, String fieldName, Object newValue) {
		try {
			Field f = clazz.getDeclaredField(fieldName);
			f.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);

			f.set(object, newValue);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T, C> T getFieldValue(C object, Class<C> clazz, String fieldName) {
		try {
			Field f = clazz.getDeclaredField(fieldName);
			f.setAccessible(true);
			return (T) f.get(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <P, C extends P> C forceSubType(Class<C> clazz, P object) {
		if (clazz.isInstance(object)) {
			throw new IllegalArgumentException("Required: " + clazz.getName() + ", got " + object.getClass().getName());
		}
		return (C) object;
	}
}
