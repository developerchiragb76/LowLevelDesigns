package org.example.ride.sharing.application.controller;

import org.example.ride.sharing.application.exception.UserNotFoundException;
import org.example.ride.sharing.application.exception.VehicleNotFoundException;
import org.example.ride.sharing.application.model.Vehicle;
import org.example.ride.sharing.application.model.VehicleType;
import org.example.ride.sharing.application.service.VehicleService;

public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void createVehicle(String userId, String vehicleType, String vehicleRegNo) throws UserNotFoundException {
        VehicleType type = VehicleType.valueOf(vehicleType);
        vehicleService.createVehicle(userId, type, vehicleRegNo);
    }

    public Vehicle getVehicleByRegNo(String regNo) throws VehicleNotFoundException {
        return vehicleService.getVehicleByRegNo(regNo);
    }
}
