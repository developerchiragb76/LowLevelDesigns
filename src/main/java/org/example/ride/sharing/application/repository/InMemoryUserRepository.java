package org.example.ride.sharing.application.repository;

import org.example.ride.sharing.application.exception.UserNotFoundException;
import org.example.ride.sharing.application.model.Ride;
import org.example.ride.sharing.application.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements IUserRepository {
    private final Map<String, User> userMap;

    public InMemoryUserRepository() {
        userMap = new HashMap<>();
    }

    @Override
    public void saveUser(User user) {
        userMap.putIfAbsent(user.getUserId(), user);
    }

    @Override
    public User getUserById(String userId) throws UserNotFoundException {
        User user = userMap.getOrDefault(userId, null);
        if(user == null) throw new UserNotFoundException(userId);

        return user;
    }

    @Override
    public List<User> allUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void addVehicle(String vehicleRegNo, String userId) throws UserNotFoundException {
        User user = userMap.get(userId);
        if(!user.getVehiclesList().contains(vehicleRegNo)) {
            user.addVehicle(vehicleRegNo);
            saveUser(user);
        }
    }

    @Override
    public void addOfferedRide(String userId, String rideId) {
        User user = userMap.get(userId);
        if(!user.getRidesOffered().contains(rideId)) {
            user.getRidesOffered().add(rideId);
            saveUser(user);
        }
    }

    @Override
    public void addRideTaken(String userId, String rideId) {
        User user = userMap.get(userId);
        if(!user.getRidesTaken().contains(rideId)) {
            user.getRidesTaken().add(rideId);
            saveUser(user);
        }
    }

    @Override
    public List<String> getAllRidesOffered(String userId) throws UserNotFoundException {
        User user = userMap.getOrDefault(userId, null);
        if(user != null) {
            return user.getRidesOffered();
        }
        throw new UserNotFoundException(userId);
    }

    @Override
    public List<String> getAllRidesTaken(String userId) throws UserNotFoundException {
        User user = userMap.getOrDefault(userId, null);
        if(user != null) {
            return user.getRidesTaken();
        }

        throw new UserNotFoundException(userId);
    }

    @Override
    public List<String> getAllRides(String userId) throws UserNotFoundException {
        User user = userMap.getOrDefault(userId, null);
        if(user != null) {
            List<String> allRides = user.getRidesTaken();
            allRides.addAll(user.getRidesOffered());
            return allRides;
        }

        throw new UserNotFoundException(userId);
    }
}
