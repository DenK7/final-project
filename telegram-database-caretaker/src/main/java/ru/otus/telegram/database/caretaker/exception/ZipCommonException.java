package ru.otus.telegram.database.caretaker.exception;

public class ZipCommonException extends RuntimeException {
    public ZipCommonException (String message, Throwable throwable) {
        super(message, throwable);
    }
}
