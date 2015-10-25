package com.shashwat.utils;

public class SanityChecks {
	public static void isTrue(boolean expression, String errorMessageTemplate,
			Object... errorMessageArguments) {
		isTrue(expression,
				String.format(errorMessageTemplate, errorMessageArguments));
	}

	public static void isTrue(boolean expression, String errorMessage) {
		if (!expression) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void notEmpty(String string, String errorMessage) {
		if (string.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void notNull(Object ref, String errorMessage) {
		if (ref == null) {
			throw new NullPointerException(errorMessage);
		}
	}
}
