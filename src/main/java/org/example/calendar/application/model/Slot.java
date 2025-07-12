package org.example.calendar.application.model;

import java.util.Date;

public class Slot {
    private Date startTime;
    private Date endTime;

    public Slot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isOverlap(Slot slot, Slot busy) {
        return !(this.getEndTime().compareTo(busy.getStartTime()) <=0 || this.getStartTime().compareTo(busy.getEndTime()) >=0);
    }
}
