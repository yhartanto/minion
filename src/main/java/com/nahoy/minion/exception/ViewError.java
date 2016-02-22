package com.nahoy.minion.exception;

public enum ViewError {
    NETWORK("Error accessing the server."), ACCESS("Access to the resource has been denied."),
    UNEXPECTED("Unexpected error has occured.");

    private final String message;
    private Throwable cause;

    ViewError(String message) {
        this(message, new RuntimeException("Unknown cause"));
    }

    ViewError(String message, Throwable cause) {
        this.cause = cause;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public static ViewError createWithCause(ViewError viewError, Throwable cause) {
        viewError.cause = cause;
        return viewError;
    }
}