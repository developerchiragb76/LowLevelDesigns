package org.example.calendar.application.repository;

import org.example.calendar.application.exception.UserNotFoundException;
import org.example.calendar.application.model.Event;
import org.example.calendar.application.model.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEventRepository implements IEventRepository {
    private final Map<String, List<Event>> userEventsMap;

    public InMemoryEventRepository() {
        this.userEventsMap = new HashMap<>();
    }

    @Override
    public void saveEvent(String userEmail, Event event) throws UserNotFoundException {
        List<Event> userEvents = userEventsMap.getOrDefault(userEmail, null);
        if(userEvents == null) throw new UserNotFoundException(userEmail);

        if(!userEvents.contains(event)) {
            userEvents.add(event);
        }
    }

    @Override
    public List<Event> getCalendarForAllUsers() {
        List<Event> allEvents = new ArrayList<>();
        for(Map.Entry<String, List<Event>> entry : userEventsMap.entrySet()) {
            allEvents.addAll(entry.getValue());
        }

        return allEvents;
    }

    @Override
    public Event getEventById(String userEmail, String eventId) throws UserNotFoundException {
        List<Event> userEvents = userEventsMap.getOrDefault(userEmail, null);
        if(userEvents == null) throw new UserNotFoundException(userEmail);
        return userEvents.stream().filter(e -> e.getEventId().equals(eventId)).findFirst().orElse(null);
    }

    @Override
    public void deleteEvent(String userEmail, String eventId) throws UserNotFoundException {
        List<Event> userEvents = userEventsMap.getOrDefault(eventId, null);
        if(userEvents == null) throw new UserNotFoundException(userEmail);
        Event event = userEvents.stream().filter(e -> e.getEventId().equals(eventId)).findFirst().orElse(null);
        userEvents.remove(event);
    }

    @Override
    public List<Event> getUserCalendar(String userEmail) {
        return new ArrayList<>(userEventsMap.get(userEmail));
    }

    @Override
    public List<Slot> getUserSlots(String userEmail) {
        return userEventsMap.get(userEmail).stream().map(Event::getSlot).toList();
    }
}
