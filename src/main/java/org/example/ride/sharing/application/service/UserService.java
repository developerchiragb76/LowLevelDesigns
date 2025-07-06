package org.example.ride.sharing.application.service;

import org.example.ride.sharing.application.exception.UserNotFoundException;
import org.example.ride.sharing.application.model.Gender;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.User;
import org.example.ride.sharing.application.repository.IUserRepository;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(String userName, Gender gender, int age) {
        User user = new User(UUID.randomUUID().toString(), userName, gender, age);
        userRepository.saveUser(user);
        return user.getUserId();
    }

    public User getUserById(String userId) throws UserNotFoundException {
        return userRepository.getUserById(userId);
    }

    public void addVehicle(String vehicleRegNo, String userId) throws UserNotFoundException {
        userRepository.addVehicle(vehicleRegNo, userId);
    }

    public void addOfferedRide(String userId, String rideId) {
        userRepository.addOfferedRide(userId, rideId);
    }

    public void addRideTaken(String userId, String rideId) {
        userRepository.addRideTaken(userId, rideId);
    }

    public List<String> getAllRidesOffered(String userId) throws UserNotFoundException {
        return userRepository.getAllRidesOffered(userId);
    }

    public List<String> getAllRidesTaken(String userId) throws UserNotFoundException {
        return userRepository.getAllRidesTaken(userId);
    }

    public List<String> getAllRides(String userId) throws UserNotFoundException {
        return userRepository.getAllRides(userId);
    }
}
