package org.example.calendar.application.service;

import org.example.calendar.application.exception.UserNotFoundException;
import org.example.calendar.application.model.*;
import org.example.calendar.application.repository.IEventRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EventService {
    private final IEventRepository eventRepository;
    private final UserService userService;
    private final SlotService slotService;

    public EventService(IEventRepository eventRepository, UserService userService, SlotService slotService) {
        this.eventRepository = eventRepository;
        this.userService = userService;
        this.slotService = slotService;
    }

    public String createEvent(String ownerEmail, Date eventStartDate, Date eventEndDate, EventType eventType, List<String> participantsList, String eventTitle, IEventData eventData, Location location) throws UserNotFoundException {
        // validations

        User owner = userService.getUserByEmail(ownerEmail);
        if(owner == null)
            throw new UserNotFoundException(ownerEmail);

        for(String participantEmailId : participantsList) {
            User participant = userService.getUserByEmail(participantEmailId);
            if(participant == null) throw new UserNotFoundException(participantEmailId);
        }

        final Event event = new Event(UUID.randomUUID().toString(), new Slot(eventStartDate, eventEndDate), location, owner, eventData, eventType, eventTitle, participantsList);
        eventRepository.saveEvent(owner.getUserEmail(), event);
        return event.getEventId();
    }

    public void updateEvent(String userEmail, Event event) throws UserNotFoundException {
        eventRepository.saveEvent(userEmail, event);
    }

    public void deleteEvent(String userEmail, String eventId) throws UserNotFoundException {
        eventRepository.deleteEvent(userEmail, eventId);
    }

    public List<Event> getCalendarForAllUsers() {
        return eventRepository.getCalendarForAllUsers();
    }

    public Event getEventById(String userEmail, String eventId) throws UserNotFoundException {
        return eventRepository.getEventById(userEmail, eventId);
    }

    public void acceptEvent(String userEmail, String eventId) throws UserNotFoundException {
        Event event = eventRepository.getEventById(userEmail, eventId);
        userService.getUserByEmail(userEmail);
        event.acceptEvent(userEmail);
    }

    public void rejectEvent(String userEmail, String eventId) throws UserNotFoundException {
        Event event = eventRepository.getEventById(userEmail, eventId);
        userService.getUserByEmail(userEmail);
        event.rejectEvent(userEmail);
    }

    public List<Event> getUserCalendar(String userEmail) {
        return eventRepository.getUserCalendar(userEmail);
    }

    public List<Slot> findCommonFreeSlot(List<String> userEmails, Date startDate, Date endDate, int duration, int increment) {
        List<Slot> allSlots = slotService.getAllSlots(startDate, endDate, duration, increment);
        List<Slot> busySlots = new ArrayList<>();
        for(String userEmail : userEmails) {
            User user = userService.getUserByEmail(userEmail);
            List<Event> events = eventRepository.getUserCalendar(user.getUserEmail());
            for(Event event : events) {
                busySlots.add(event.getSlot());
            }
        }

        return allSlots.stream()
                .filter(slot -> busySlots.stream().noneMatch(busy -> busy.isOverlap(slot, busy)))
                .collect(Collectors.toList());
    }
}
