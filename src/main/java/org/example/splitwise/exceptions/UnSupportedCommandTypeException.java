package org.example.splitwise.exceptions;

public class UnSupportedCommandTypeException extends Throwable {
    public UnSupportedCommandTypeException(String commandType) {
        super("Command Type " + commandType + " not supported");
    }
}
