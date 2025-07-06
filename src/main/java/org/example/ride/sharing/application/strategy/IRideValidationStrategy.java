package org.example.ride.sharing.application.strategy;

import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideInput;


public interface IRideValidationStrategy {
    boolean validate(Ride ride, RideInput rideInput);
}
