package ru.job4j.concurrent;

public class OptimisticException extends RuntimeException {
    private String messages;

    public OptimisticException() {
        super();
    }

    public OptimisticException(String message) {
        super(message);
    }

    public OptimisticException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptimisticException(Throwable cause) {
        super(cause);
    }

    protected OptimisticException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
