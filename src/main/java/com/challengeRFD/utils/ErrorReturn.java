package com.challengeRFD.utils;

/**
 * Simple class for error returns in API calls
 */
public class ErrorReturn {
    public int status;
    public String error;
    public String description;

    public ErrorReturn (int status, String error, String description){
        this.status = status; //HTTP code
        this.error = error; //HTTP error + short description
        this.description = description; //long description
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
