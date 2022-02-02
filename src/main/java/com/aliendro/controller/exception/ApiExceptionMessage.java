package com.aliendro.controller.exception;

public class ApiExceptionMessage {

    private String exception;

    public ApiExceptionMessage(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
