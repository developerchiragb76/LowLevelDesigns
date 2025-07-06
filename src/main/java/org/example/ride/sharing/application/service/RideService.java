package org.example.ride.sharing.application.service;

import org.example.ride.sharing.application.controller.UserController;
import org.example.ride.sharing.application.controller.VehicleController;
import org.example.ride.sharing.application.exception.*;
import org.example.ride.sharing.application.model.*;
import org.example.ride.sharing.application.repository.IRideRepository;
import org.example.ride.sharing.application.strategy.IRidePickStrategy;
import org.example.ride.sharing.application.strategy.IRideValidationStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RideService {
    private final IRideRepository rideRepository;
    private final UserController userController;
    private final VehicleController vehicleController;
    private final List<IRideValidationStrategy> rideValidationStrategyList;
    private final List<IRidePickStrategy> ridePickStrategyList;

    public RideService(IRideRepository rideRepository, UserController userController, VehicleController vehicleController, List<IRideValidationStrategy> rideValidationStrategyList, List<IRidePickStrategy> ridePickStrategyList) {
        this.rideRepository = rideRepository;
        this.userController = userController;
        this.vehicleController = vehicleController;
        this.rideValidationStrategyList = rideValidationStrategyList;
        this.ridePickStrategyList = ridePickStrategyList;
    }

    public void offerRide(String userId, String vehicleRegNo, int seatsAvailable, String origin, String destination, Date startDate, int duration) throws UserNotFoundException, VehicleNotFoundException, NoVehicleTypeExistForUser, VehicleDoesNotBelongToTheGivenUserException {
        User user = userController.getUserById(userId);
        Vehicle userVehicle = null;
        userVehicle =  vehicleController.getVehicleByRegNo(vehicleRegNo);
        if(userVehicle == null) {
            throw new NoVehicleTypeExistForUser(userId, vehicleRegNo);
        }

        if(!userVehicle.getOwner().getUserId().equals(userId)) {
            throw new VehicleDoesNotBelongToTheGivenUserException(vehicleRegNo, userId);
        }

        Location originLocation = new Location(origin);
        Location destLocation = new Location(destination);

        Route route = new Route(originLocation, destLocation);

        Ride ride = new Ride(duration, UUID.randomUUID().toString(), route, user, userVehicle, startDate, RideStatus.SCHEDULED);
        rideRepository.saveRide(ride);
        userController.addOfferedRide(user.getUserId(), ride.getId());
    }


    public Ride selectRide(String userId, String origin, String destination, int seatsRequired, RidePreference ridePreference, VehicleType vehicleType) throws NoRideMatchingPreferenceException, UserNotFoundException {
        User user = userController.getUserById(userId);
        Location startLocation = new Location(origin);
        Location endLocation = new Location(destination);
        Route route = new Route(startLocation, endLocation);
        RideInput rideInput = new RideInput(user, route, seatsRequired, ridePreference, vehicleType);
        List<Ride> availableRides = rideRepository.getAllActiveRides();
        List<Ride> filteredRides = new ArrayList<>();
        for(Ride ride : availableRides) {
            boolean passedAll = true;
            for(IRideValidationStrategy rideValidationStrategy : rideValidationStrategyList) {
                if(!rideValidationStrategy.validate(ride, rideInput)) {
                    passedAll = false;
                    break;
                }
            }
            if(passedAll) {
                filteredRides.add(ride);
            }
        }

        for(IRidePickStrategy ridePickStrategy : ridePickStrategyList) {
            if(ridePickStrategy.doesSupport(ridePreference)) {
                Ride ride = ridePickStrategy.pickRides(filteredRides, rideInput);
                ride.getVehicle().setNoOfSeats(ride.getVehicle().getNoOfSeats() - rideInput.seatsRequired());
                rideRepository.saveRide(ride);
                userController.addRideTaken(userId, ride.getId());
            }
        }
        throw new NoRideMatchingPreferenceException(ridePreference);
    }

    public void cancelRide(String rideId) throws RideNotFoundException {
        rideRepository.cancelRide(rideId);
    }

    public void completeRide(String rideId) throws RideNotFoundException {
        rideRepository.completeRide(rideId);
    }
}
