package com.curonex.exception;

public class ResourceDAOException extends Exception {

    private static final long serialVersionUID = 1L;

    public ResourceDAOException(String message) {
        super(message);
    }

    public ResourceDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
