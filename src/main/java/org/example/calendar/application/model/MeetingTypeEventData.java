package org.example.calendar.application.model;


public class MeetingTypeEventData implements IEventData {
    private String meetingId;

    public MeetingTypeEventData(String meetingId, ILocationTypeData locationTypeData) {
        this.meetingId = meetingId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

}
