package org.example.coffee.machine.exception;

import org.example.coffee.machine.model.BeverageType;

public class BeveragePrepartionStrategyNotExistException extends Exception {
    public BeveragePrepartionStrategyNotExistException(BeverageType beverageType) {
        super("Beverage Strategy Not Exist For Beverage Type " + beverageType);
    }
}
