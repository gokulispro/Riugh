package com.curonex.exception;

public class ResourceTransferDAOException extends Exception {

    private static final long serialVersionUID = 1L;

    public ResourceTransferDAOException(String message) {
        super(message);
    }

    public ResourceTransferDAOException(
            String message,
            Throwable cause) {

        super(message, cause);
    }
}
