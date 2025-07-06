package org.example.ride.sharing.application.model;

import java.util.Objects;

public class Route {
    private final Location origin;
    private final Location destination;

    public Route(Location origin, Location destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object r) {
        if (r == null || getClass() != r.getClass()) return false;
        Route route = (Route) r;
        return this.origin.equals(route.getOrigin()) && this.destination.equals(route.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination);
    }
}
