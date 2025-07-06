package org.example.ride.sharing.application.exception;

public class NoVehicleTypeExistForUser extends Throwable {
    public NoVehicleTypeExistForUser(String userId, String vehicleRegNo) {
        super("User with " + userId + " does not have any vehicle with registration number " + vehicleRegNo);
    }
}
