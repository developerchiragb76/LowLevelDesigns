package org.example.ride.sharing.application.service;

import org.example.ride.sharing.application.controller.RideController;
import org.example.ride.sharing.application.controller.UserController;
import org.example.ride.sharing.application.controller.VehicleController;
import org.example.ride.sharing.application.exception.*;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.RidePreference;
import org.example.ride.sharing.application.model.VehicleType;

import java.util.Date;
import java.util.List;

public class RideSharingManager {
    private UserController userController;
    private VehicleController vehicleController;
    private RideController rideController;

    public String createUser(String userName, String gender, int age) {
        return userController.createUser(userName, gender, age);
    }

    public void createVehicle(String userId, String vehicleType, String vehicleRegNo) throws UserNotFoundException {
        vehicleController.createVehicle(userId, vehicleType, vehicleRegNo);
    }

    public void offerRide(String userId, String vehicleType, int seatsAvailable, String origin, String destination, Date startDate, int duration) throws UserNotFoundException, VehicleNotFoundException, NoVehicleTypeExistForUser {
        rideController.offerRide(userId, vehicleType, seatsAvailable, origin, destination, startDate, duration);
    }

    public Ride selectRide(String userId, String origin, String destination, int seatsRequired, RidePreference ridePreference, VehicleType preferredVehicle) throws UserNotFoundException, RideValidationCriteriaNotMetException, NoRideMatchingPreferenceException {
        return rideController.selectRide(userId, origin, destination, seatsRequired, ridePreference, preferredVehicle);
    }

    public List<String> viewRidesOffered(String userId) throws UserNotFoundException {
        return userController.getAllRidesOffered(userId);
    }

    public List<String> viewRidesTaken(String userId) throws UserNotFoundException {
        return userController.getAllRidesTaken(userId);
    }

    public List<String> viewAllRides(String userId) throws UserNotFoundException {
        return userController.getAllRides(userId);
    }
}
