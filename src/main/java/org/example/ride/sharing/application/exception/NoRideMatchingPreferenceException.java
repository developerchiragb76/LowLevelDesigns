package org.example.ride.sharing.application.exception;

import org.example.ride.sharing.application.model.RidePreference;

public class NoRideMatchingPreferenceException extends Throwable {
    public NoRideMatchingPreferenceException(RidePreference ridePreference) {
        super("No Rides Matching With " + ridePreference + "Found");
    }
}
