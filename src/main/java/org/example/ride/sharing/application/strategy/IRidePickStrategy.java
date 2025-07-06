package org.example.ride.sharing.application.strategy;

import org.example.ride.sharing.application.exception.NoRideMatchingPreferenceException;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideInput;
import org.example.ride.sharing.application.model.RidePreference;

import java.util.List;

public interface IRidePickStrategy {
    boolean doesSupport(RidePreference ridePreference);
    Ride pickRides(List<Ride> allRides, RideInput rideInput) throws NoRideMatchingPreferenceException;
}
