package org.example.ride.sharing.application.strategy;

import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideInput;

public class RouteMatchingRideValidationStrategy implements IRideValidationStrategy {
    @Override
    public boolean validate(Ride ride, RideInput rideInput) {
        return ride.getRoute().equals(rideInput.route());
    }
}
