package org.example.ride.sharing.application.model;


import org.example.ride.sharing.application.service.RideService;

import java.util.Date;

public class Ride {
    private final String id;
    private final Route route;
    private final User bookingUser;
    private final Vehicle vehicle;
    private final Date startDate;
    private final int duration;
    private RideStatus rideStatus;

    public Ride(int duration, String id, Route route, User bookingUser, Vehicle vehicle, Date startDate, RideStatus rideStatus) {
        this.duration = duration;
        this.id = id;
        this.route = route;
        this.bookingUser = bookingUser;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.rideStatus = rideStatus;
    }

    public Route getRoute() {
        return route;
    }

    public User getBookingUser() {
        return bookingUser;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getDuration() {
        return duration;
    }

    public String getId() {
        return id;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }
}
