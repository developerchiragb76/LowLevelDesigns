package org.example.ride.sharing.application.controller;

import org.example.ride.sharing.application.exception.*;
import org.example.ride.sharing.application.model.*;
import org.example.ride.sharing.application.service.RideService;

import java.util.Date;
import java.util.List;

public class RideController {
    private RideService rideService;
    private UserController userController;

    public void offerRide(String userId, String vehicleRegNo, int seatsAvailable, String origin, String destination, Date startDate, int duration) throws UserNotFoundException, NoVehicleTypeExistForUser, VehicleNotFoundException, VehicleDoesNotBelongToTheGivenUserException {
        rideService.offerRide(userId, vehicleRegNo, seatsAvailable, origin, destination, startDate, duration);
    }

    public Ride selectRide(String userId, String origin, String destination, int seatsRequired, RidePreference ridePreference, VehicleType vehicleType) throws UserNotFoundException, RideValidationCriteriaNotMetException, NoRideMatchingPreferenceException {
        return rideService.selectRide(userId, origin, destination, seatsRequired, ridePreference, vehicleType);
    }

    public void cancelRide(String rideId) throws RideNotFoundException {
        rideService.cancelRide(rideId);
    }

    public void completeRide(String rideId) throws RideNotFoundException {
        rideService.completeRide(rideId);
    }


}


