package org.example.ride.sharing.application.repository;

import org.example.ride.sharing.application.exception.RideNotFoundException;
import org.example.ride.sharing.application.model.Ride;

import java.util.List;

public interface IRideRepository {
    void saveRide(Ride ride);
    Ride getRideById(String rideId) throws RideNotFoundException;
    List<Ride> getAllRides();
    List<Ride> getAllActiveRides();

    void cancelRide(String rideId) throws RideNotFoundException;

    void completeRide(String rideId) throws RideNotFoundException;
}
