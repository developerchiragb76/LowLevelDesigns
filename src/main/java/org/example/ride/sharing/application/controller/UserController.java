package org.example.ride.sharing.application.controller;

import org.example.ride.sharing.application.exception.UserNotFoundException;
import org.example.ride.sharing.application.model.Gender;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.User;
import org.example.ride.sharing.application.service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String createUser(String userName, String userGender, int age) {
        Gender gender = Gender.valueOf(userGender);
        return userService.createUser(userName, gender, age);
    }

    public User getUserById(String userId) throws UserNotFoundException {
        return userService.getUserById(userId);
    }

    public void addVehicle(String vehicleRegNo, String userId) throws UserNotFoundException {
        userService.addVehicle(vehicleRegNo, userId);
    }

    public void addOfferedRide(String userId, String rideId) {
        userService.addOfferedRide(userId, rideId);
    }

    public void addRideTaken(String userId, String rideId) {
        userService.addRideTaken(userId, rideId);
    }

    public List<String> getAllRidesOffered(String userId) throws UserNotFoundException {
        return userService.getAllRidesOffered(userId);
    }

    public List<String> getAllRidesTaken(String userId) throws UserNotFoundException {
        return userService.getAllRidesTaken(userId);
    }

    public List<String> getAllRides(String userId) throws UserNotFoundException {
        return userService.getAllRides(userId);
    }
}
