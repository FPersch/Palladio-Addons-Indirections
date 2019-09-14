package org.palladiosimulator.indirections.scheduler.util;

import java.util.Map;
import java.util.Map.Entry;

import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.Parameter;

public final class IndirectionUtil {
	private IndirectionUtil() {

	}
	
	public static void validateStackframeStructure(Map<String, Object> dataMap, String parameterName) {
		String parameterCharacterisationPrefix = parameterName + ".";

		for (Entry<String, Object> entry : dataMap.entrySet()) {
			if (!entry.getKey().startsWith(parameterCharacterisationPrefix)) {
				throw new IllegalArgumentException("Invalid characteristation for data frame: " + entry.getKey()
						+ ", expected characteristations for " + parameterName);
			}
		}
	}

	public static Parameter getOneParameter(EventGroup eventGroup) {
		return IterableUtil.claimOne(eventGroup.getEventTypes__EventGroup()).getParameter__EventType();
	}

	/**
	 * Changes the prefix in the given variable name from the parameter name of the
	 * incoming event type to the one of the outgoing event type.
	 */
	public static String rewriteVariableNamePrefix(String variableName, String incomingParameterName,
			String outgoingParameterName) {
		if (variableName.startsWith(incomingParameterName)) {
			return outgoingParameterName + variableName.substring(incomingParameterName.length());
		} else {
			throw new AssertionError("Variable '" + variableName + "' does not start with incoming paramete name: "
					+ incomingParameterName);
		}
	}
}
