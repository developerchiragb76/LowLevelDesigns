package org.example.ride.sharing.application.strategy;

import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideInput;
import org.example.ride.sharing.application.model.RidePreference;

import java.util.List;

public class EarliestEndingRideStrategyImpl implements IRidePickStrategy {
    @Override
    public boolean doesSupport(RidePreference ridePreference) {
        return RidePreference.EARLIEST_ENDING.equals(ridePreference);
    }

    @Override
    public Ride pickRides(List<Ride> allRides, RideInput rideInput) {
        allRides.sort((a,b) -> b.getDuration() - a.getDuration());
        return allRides.get(0);
    }
}
