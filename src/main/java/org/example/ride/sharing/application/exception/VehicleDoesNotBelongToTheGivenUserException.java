package org.example.ride.sharing.application.exception;

public class VehicleDoesNotBelongToTheGivenUserException extends Throwable {
    public VehicleDoesNotBelongToTheGivenUserException(String vehicleRegNo, String userId) {
        super("Provided Vehicle With " + vehicleRegNo + " Does Not Belong To The User " + userId);
    }
}
