package com.skilciti.springboot.tutorial.errors;

public class ExceptionNotFound extends Exception{
    public ExceptionNotFound() {
        super();
    }

    public ExceptionNotFound(String message) {
        super(message);
    }

    public ExceptionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionNotFound(Throwable cause) {
        super(cause);
    }

    protected ExceptionNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
