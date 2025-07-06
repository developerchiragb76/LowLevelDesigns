package org.example.ride.sharing.application.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private final String userName;
    private final Gender gender;
    private final int age;
    private final List<String> vehiclesList;
    private final List<String> ridesTaken;
    private final List<String> ridesOffered;

    public User(String userId, String userName, Gender gender, int age) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.vehiclesList = new ArrayList<>();
        this.ridesOffered = new ArrayList<>();
        this.ridesTaken = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public List<String> getVehiclesList() {
        return new ArrayList<>(vehiclesList);
    }

    public void addVehicle(String vehicleRegNo) {
        vehiclesList.add(vehicleRegNo);
    }

    public void addToOfferRide(String rideId) {
        ridesOffered.add(rideId);
    }

    public void addToRideTaken(String rideId) {
        ridesTaken.add(rideId);
    }

    public List<String> getRidesTaken() {
        return new ArrayList<>(ridesTaken);
    }

    public List<String> getRidesOffered() {
        return new ArrayList<>(ridesOffered);
    }
}
