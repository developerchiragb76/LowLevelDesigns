package org.example.coffee.machine.exception;

import org.example.coffee.machine.model.BeverageType;

public class BeverageDoesNotExist extends Exception {
    public BeverageDoesNotExist(BeverageType beverageType) {
        super("Beverage " + beverageType + " Not Exist");
    }
}
