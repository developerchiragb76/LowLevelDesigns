package org.example.calendar.application.model;

public class VirtualLocationTypeData implements ILocationTypeData {
    private String url;

    public VirtualLocationTypeData(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


