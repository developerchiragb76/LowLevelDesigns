package org.example.ride.sharing.application.repository;

import org.example.ride.sharing.application.exception.RideNotFoundException;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RideStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRideRepository implements IRideRepository{
    private final Map<String, Ride> rideMap;

    public InMemoryRideRepository() {
        this.rideMap = new HashMap<>();
    }

    @Override
    public void saveRide(Ride ride) {
        rideMap.put(ride.getId(), ride);
    }

    @Override
    public Ride getRideById(String rideId) throws RideNotFoundException {
        Ride ride = rideMap.get(rideId);
        if(ride == null) throw new RideNotFoundException(rideId);
        return ride;
    }

    @Override
    public List<Ride> getAllRides() {
        return new ArrayList<>(rideMap.values());
    }

    @Override
    public List<Ride> getAllActiveRides() {
        return rideMap.values().stream().filter(ride -> ride.getRideStatus().equals(RideStatus.SCHEDULED)).toList();
    }

    @Override
    public void cancelRide(String rideId) throws RideNotFoundException {
        Ride ride = rideMap.getOrDefault(rideId, null);
        if(ride == null) throw new RideNotFoundException(rideId);
        ride.setRideStatus(RideStatus.CANCELLED);
        saveRide(ride);
    }

    @Override
    public void completeRide(String rideId) throws RideNotFoundException {
        Ride ride = rideMap.getOrDefault(rideId, null);
        if(ride == null) throw new RideNotFoundException(rideId);
        ride.setRideStatus(RideStatus.COMPLETED);
        saveRide(ride);
    }
}
