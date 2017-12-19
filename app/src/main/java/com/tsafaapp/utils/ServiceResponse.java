package com.tsafaapp.utils;

public class ServiceResponse {

    private final boolean error;
    private final String message;

    protected ServiceResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public static ServiceResponse error(String message) {
        return new ServiceResponse(true, message);
    }

    public static ServiceResponse ok(String message) {
        return new ServiceResponse(false, message);
    }

    public static ServiceResponse ok() {
        return ServiceResponse.ok("");
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
