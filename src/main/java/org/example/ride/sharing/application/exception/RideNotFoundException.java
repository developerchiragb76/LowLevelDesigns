package org.example.ride.sharing.application.exception;

public class RideNotFoundException extends Throwable {
    public RideNotFoundException(String rideId) {
        super("Ride " + rideId + " Does Not Exist");
    }
}
