package org.example.calendar.application.repository;

import org.example.calendar.application.exception.UserNotFoundException;
import org.example.calendar.application.model.Event;
import org.example.calendar.application.model.Slot;

import java.util.List;

public interface IEventRepository {
    void saveEvent(String email, Event event) throws UserNotFoundException;
    List<Event> getCalendarForAllUsers();
    Event getEventById(String email, String eventId) throws UserNotFoundException;
    void deleteEvent(String email, String eventId) throws UserNotFoundException;

    List<Event> getUserCalendar(String userEmail);

    List<Slot> getUserSlots(String userEmail);
}
