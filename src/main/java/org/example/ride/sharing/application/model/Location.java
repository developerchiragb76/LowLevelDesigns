package org.example.ride.sharing.application.model;

import java.util.Objects;

public class Location {
    private final String locationName;

    public Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Location location = (Location) object;
        return this.locationName.equals(location.getLocationName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(locationName);
    }
}
