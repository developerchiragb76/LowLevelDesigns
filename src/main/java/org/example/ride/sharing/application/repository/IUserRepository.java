package org.example.ride.sharing.application.repository;

import org.example.ride.sharing.application.exception.UserNotFoundException;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.User;

import java.util.List;

public interface IUserRepository {
    void saveUser(User user);
    User getUserById(String userId) throws UserNotFoundException;
    List<User> allUsers();
    void addVehicle(String vehicleRegNo, String userId) throws UserNotFoundException;

    void addOfferedRide(String userId, String rideId);

    void addRideTaken(String userId, String rideId);

    List<String> getAllRidesOffered(String userId) throws UserNotFoundException;

    List<String> getAllRidesTaken(String userId) throws UserNotFoundException;

    List<String> getAllRides(String userId) throws UserNotFoundException;
}
