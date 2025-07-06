package org.example.ride.sharing.application.model;

import java.util.Objects;

public final class RideInput {
    private final User user;
    private final Route route;
    private final int seatsRequired;
    private final RidePreference ridePreference;
    private final VehicleType vehicleType;

    public RideInput(User user, Route route, int seatsRequired, RidePreference ridePreference, VehicleType vehicleType) {
        this.user = user;
        this.route = route;
        this.seatsRequired = seatsRequired;
        this.ridePreference = ridePreference;
        this.vehicleType = vehicleType;
    }

    public User user() {
        return user;
    }

    public Route route() {
        return route;
    }

    public int seatsRequired() {
        return seatsRequired;
    }

    public RidePreference ridePreference() {
        return ridePreference;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RideInput) obj;
        return Objects.equals(this.user, that.user) &&
                Objects.equals(this.route, that.route) &&
                this.seatsRequired == that.seatsRequired &&
                Objects.equals(this.ridePreference, that.ridePreference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, route, seatsRequired, ridePreference);
    }

    @Override
    public String toString() {
        return "RideInput[" +
                "user=" + user + ", " +
                "route=" + route + ", " +
                "seatsRequired=" + seatsRequired + ", " +
                "ridePreference=" + ridePreference + ']';
    }

}
