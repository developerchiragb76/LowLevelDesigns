package org.example.ride.sharing.application.model;

public class Vehicle {
    private final String regNo;
    private final User owner;
    private final VehicleType vehicleType;
    private int noOfSeats;

    public Vehicle(String regNo, User owner, VehicleType vehicleType) {
        this.regNo = regNo;
        this.owner = owner;
        this.vehicleType = vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public User getOwner() {
        return owner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}


