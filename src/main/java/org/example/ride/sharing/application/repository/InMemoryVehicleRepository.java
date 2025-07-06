package org.example.ride.sharing.application.repository;

import org.example.ride.sharing.application.exception.VehicleNotFoundException;
import org.example.ride.sharing.application.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryVehicleRepository implements IVehicleRepository {
    private final Map<String, Vehicle> vehicleMap;

    public InMemoryVehicleRepository() {
        vehicleMap = new HashMap<>();
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleMap.putIfAbsent(vehicle.getRegNo(), vehicle);
    }

    @Override
    public Vehicle getVehicleByRegNo(String regNo) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleMap.getOrDefault(regNo, null);
        if(vehicle == null) throw new VehicleNotFoundException(regNo);

        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicleMap.values());
    }
}
