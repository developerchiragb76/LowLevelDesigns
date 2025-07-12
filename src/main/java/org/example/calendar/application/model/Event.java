package org.example.calendar.application.model;

import java.util.*;

public class Event {
    private final String eventId;
    private final Location eventLocation;
    private Slot slot;
    private final User eventOwner;
    private final IEventData eventData;
    private EventType eventType;
    private String eventTitle;
    private final List<String> participantEmails;
    private final Map<String, EventState> userToEventStateMap;

    public Event(String eventId, Slot slot, Location eventLocation, User eventOwner, IEventData eventData, EventType eventType, String eventTitle, List<String> participantEmails) {
        this.eventId = eventId;
        this.slot = slot;
        this.eventOwner = eventOwner;
        this.eventData = eventData;
        this.eventType = eventType;
        this.eventTitle = eventTitle;
        this.participantEmails = participantEmails;
        this.eventLocation = eventLocation;
        this.userToEventStateMap = new HashMap<>();
        userToEventStateMap.putIfAbsent(eventOwner.getUserEmail(), EventState.NEUTRAL);
        for(String email : participantEmails) {
            userToEventStateMap.putIfAbsent(email, EventState.NEUTRAL);
        }
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getEventId() {
        return eventId;
    }

    public User getEventOwner() {
        return eventOwner;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void addParticipantToEvent(String emailId) {
        if(!participantEmails.contains(emailId)) participantEmails.add(emailId);
    }

    public void deleteParticipantFromEvent(String emailId) {
        participantEmails.remove(emailId);
    }

    public List<String> getParticipantEmails() {
        return new ArrayList<>(participantEmails);
    }

    public IEventData getEventData() {
        return eventData;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void acceptEvent(String userEmail) {
        userToEventStateMap.put(userEmail, EventState.ACCEPTED);
    }

    public void rejectEvent(String userEmail) {
        userToEventStateMap.put(userEmail, EventState.REJECTED);
    }

    public Location getEventLocation() {
        return eventLocation;
    }
}
