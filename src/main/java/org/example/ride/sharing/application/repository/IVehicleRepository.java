package org.example.ride.sharing.application.repository;

import org.example.ride.sharing.application.exception.VehicleNotFoundException;
import org.example.ride.sharing.application.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    void saveVehicle(Vehicle vehicle);
    Vehicle getVehicleByRegNo(String regNo) throws VehicleNotFoundException;
    List<Vehicle> getAllVehicles();
}
