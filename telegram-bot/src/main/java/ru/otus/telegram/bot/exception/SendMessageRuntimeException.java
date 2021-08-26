package ru.otus.telegram.bot.exception;

public class SendMessageRuntimeException extends RuntimeException {
    public SendMessageRuntimeException (String message) {
        super(message);
    }
}
