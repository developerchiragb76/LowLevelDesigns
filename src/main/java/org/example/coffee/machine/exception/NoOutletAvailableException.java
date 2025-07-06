package org.example.coffee.machine.exception;

public class NoOutletAvailableException extends Throwable {
    public NoOutletAvailableException(String noOutletAvailable) {
        super(noOutletAvailable);
    }
}
