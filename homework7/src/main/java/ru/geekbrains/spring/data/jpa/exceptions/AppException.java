package ru.geekbrains.spring.data.jpa.exceptions;

public class AppException {
    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppException() {
    }

    public AppException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
