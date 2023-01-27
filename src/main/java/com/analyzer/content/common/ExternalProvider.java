package com.analyzer.content.common;

import java.util.stream.Stream;

/**
 * @author Hikmet
 * @since 28-01-2023+03:00
 */
public enum ExternalProvider {

    MEDIUM("medium"),
    LINKEDIN("linkedin"),
    QUORA("quora");

    private final String value;

    ExternalProvider(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExternalProvider of(String value) {
        return Stream.of(ExternalProvider.values())
                .filter(status -> status.value.equals(value)).findFirst().orElse(null);
    }
}
