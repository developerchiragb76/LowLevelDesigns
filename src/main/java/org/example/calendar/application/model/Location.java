package org.example.calendar.application.model;

public class Location {
    private String locationTitle;
    private ILocationTypeData locationTypeData;

    public Location(String locationTitle, ILocationTypeData locationTypeData) {
        this.locationTitle = locationTitle;
        this.locationTypeData = locationTypeData;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public ILocationTypeData getLocationTypeData() {
        return locationTypeData;
    }

    public void setLocationTypeData(ILocationTypeData locationTypeData) {
        this.locationTypeData = locationTypeData;
    }
}
