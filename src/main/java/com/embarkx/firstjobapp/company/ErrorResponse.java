package com.embarkx.firstjobapp.company;

public class ErrorResponse {

    private String Message;

    public ErrorResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
