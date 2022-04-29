package com.challengeRFD.utils;

public class ErrorReturn {
    public int status;
    public String error;
    public String description;

    public ErrorReturn (int status, String error, String description){
        this.status = status;
        this.error = error;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }
}
