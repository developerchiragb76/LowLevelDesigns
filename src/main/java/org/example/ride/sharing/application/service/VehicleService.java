package org.example.ride.sharing.application.service;

import org.example.ride.sharing.application.exception.UserNotFoundException;
import org.example.ride.sharing.application.exception.VehicleNotFoundException;
import org.example.ride.sharing.application.model.User;
import org.example.ride.sharing.application.model.Vehicle;
import org.example.ride.sharing.application.model.VehicleType;
import org.example.ride.sharing.application.repository.IUserRepository;
import org.example.ride.sharing.application.repository.IVehicleRepository;

public class VehicleService {
    private final IVehicleRepository vehicleRepository;
    private final IUserRepository userRepository;

    public VehicleService(IVehicleRepository vehicleRepository, IUserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    public void createVehicle(String userId, VehicleType type, String vehicleRegNo) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        Vehicle vehicle = new Vehicle(vehicleRegNo, user, type);

        vehicleRepository.saveVehicle(vehicle);
        userRepository.addVehicle(vehicleRegNo, userId);
    }

    public Vehicle getVehicleByRegNo(String regNo) throws VehicleNotFoundException {
        return vehicleRepository.getVehicleByRegNo(regNo);
    }
}
