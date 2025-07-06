package org.example.ride.sharing.application.exception;

public class VehicleNotFoundException extends Throwable {
    public VehicleNotFoundException(String regNo) {
        super("Vehicle With " + regNo + " Not Found");
    }
}
