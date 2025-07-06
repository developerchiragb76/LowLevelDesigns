package org.example.ride.sharing.application.strategy;

import org.example.ride.sharing.application.exception.NoRideMatchingPreferenceException;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideInput;
import org.example.ride.sharing.application.model.RidePreference;

import java.util.List;

public class MostVacantRideStrategyImpl implements IRidePickStrategy {
    @Override
    public boolean doesSupport(RidePreference ridePreference) {
        return false;
    }

    @Override
    public Ride pickRides(List<Ride> allRides, RideInput rideInput) throws NoRideMatchingPreferenceException {
        allRides.sort((a,b) -> b.getVehicle().getNoOfSeats() - a.getVehicle().getNoOfSeats());
        Ride ride = allRides.get(0);
        if(ride.getVehicle().getNoOfSeats() >= rideInput.seatsRequired()) {
            return ride;
        }

        throw new NoRideMatchingPreferenceException(rideInput.ridePreference());
    }
}
