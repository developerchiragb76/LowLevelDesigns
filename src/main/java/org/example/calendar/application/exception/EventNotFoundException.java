package org.example.calendar.application.exception;

public class EventNotFoundException extends Throwable {
    public EventNotFoundException(String eventId) {
        super("Event With Event ID " + eventId + " Not Found");
    }
}
