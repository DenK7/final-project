package ru.otus.telegram.database.caretaker.exception;

public class DateIsNotCorrectException extends RuntimeException {
    public DateIsNotCorrectException(String message) {
        super(message);
    }
}
