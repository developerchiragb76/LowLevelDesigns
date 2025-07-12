package org.example.calendar.application.service;

import org.example.calendar.application.exception.UserNotFoundException;
import org.example.calendar.application.model.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CalendarService {
    private UserService userService;
    private EventService eventService;

    public String addEvent(String ownerEmail, Date startDate, Date endDate, Location location, List<String> participantEmails, String eventTitle, EventType eventType, IEventData eventData) throws UserNotFoundException {
       return eventService.createEvent(ownerEmail, startDate, endDate, eventType, participantEmails, eventTitle, eventData, location);
    }

    public void updateEvent(String userEmail, Event event) throws UserNotFoundException {
        eventService.updateEvent(userEmail, event);
    }

    public void deleteEvent(String userEmail, String eventId) throws UserNotFoundException {
        eventService.deleteEvent(userEmail, eventId);
    }

    public List<Event> getUserCalendar(String userEmail) throws UserNotFoundException {
        User user = userService.getUserByEmail(userEmail);
        if(user == null) throw new UserNotFoundException(userEmail);
        return eventService.getUserCalendar(userEmail);
    }

    public List<Event> getAllEvents() {
        return eventService.getCalendarForAllUsers();
    }

    public void acceptEvent(String userEmail, String eventId) throws UserNotFoundException {
        eventService.acceptEvent(userEmail, eventId);
    }

    public void rejectEvent(String userEmail, String eventId) throws UserNotFoundException {
        eventService.rejectEvent(userEmail, eventId);
    }

    public List<Slot> findCommonFreeSlot(List<String> userEmailIds, Date startDate, Date endDate, int duration, int increment) throws UserNotFoundException {
        return eventService.findCommonFreeSlot(userEmailIds, startDate, endDate, duration, increment);
    }

    public Optional<Slot> findFirstCommonFreeSlot(List<String> userEmails, Date startDate, Date endDate, int duration, int increment) throws UserNotFoundException {
        List<Slot> allSlots = findCommonFreeSlot(userEmails, startDate, endDate, duration, increment);
        return allSlots.stream().findFirst();
    }
}
