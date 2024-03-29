package com.mobeye.geolocation;

public enum GeolocationError {
    NO_LOCATION_AVAILABLE(2, "No location in buffer"),
    LOCATION_NOT_CONFIGURED(3, "Location service is not configured"), // iOS only
    INVALID_CONFIGURATION(4, "Configuration is invalid"),
    UNKNOWN_AUTHORIZATION_STATUT(5, "Unknown authorization status"), // iOS only
    UNKNOWN_ACCURACY_AUTHORIZATION(6, "Unknown accuracy authorization"), // iOS only
    CHECK_SETTINGS_FAILURE(7,"Check settings request failure"),
    AUTHORIZATION_DENIED(8,"User unauthorized the location update"), // iOS only
    HEADING_FAILURE(
            9,
            "Location not determined: too strong interference from nearby magnetic fields"
    ), // iOS only
    DEFAULT_ERROR(1000, "Default error");

    private final int code;
    private final String description;

    GeolocationError(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static GeolocationError getByCode(int errorCode) {
        for (GeolocationError e : values()) {
            if (e.code == errorCode) return e;
        }
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
