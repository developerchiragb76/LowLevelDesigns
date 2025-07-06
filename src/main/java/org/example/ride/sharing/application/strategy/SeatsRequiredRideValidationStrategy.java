package org.example.ride.sharing.application.strategy;

import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideInput;


public class SeatsRequiredRideValidationStrategy implements IRideValidationStrategy {

    @Override
    public boolean validate(Ride ride, RideInput rideInput) {
        return rideInput.seatsRequired() <= ride.getVehicle().getNoOfSeats();
    }
}
