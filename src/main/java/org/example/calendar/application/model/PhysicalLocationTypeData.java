package org.example.calendar.application.model;


public class PhysicalLocationTypeData implements ILocationTypeData {
    private Address address;

    public PhysicalLocationTypeData(Address address) {
        this.address = address;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
