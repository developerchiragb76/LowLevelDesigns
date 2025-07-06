package org.example.ride.sharing.application.strategy;

import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideInput;

public class PreferredVehicleRideValidationStrategy implements IRideValidationStrategy {
    @Override
    public boolean validate(Ride ride, RideInput rideInput) {
        if(rideInput.getVehicleType() == null) return true;
        return rideInput.getVehicleType().equals(ride.getVehicle().getVehicleType());
    }
}
