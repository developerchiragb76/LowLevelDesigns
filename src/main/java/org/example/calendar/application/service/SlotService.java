package org.example.calendar.application.service;

import org.example.calendar.application.model.Slot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SlotService {
    public List<Slot> getAllSlots(Date startDate, Date endDate, int duration, int increment) {
        List<Slot> availableSlots = new ArrayList<>();
        long durationMillis = duration*60*1000;
        long incrementMillis = increment * 60 * 1000;

        long startTime = startDate.getTime();
        long endTime = endDate.getTime();

        while(startTime + durationMillis <= endTime) {
            Date slotStart = new Date(startTime);
            Date slotEnd = new Date(startTime + durationMillis);
            availableSlots.add(new Slot(slotStart, slotEnd));
            startTime += incrementMillis;
        }

        return availableSlots;
    }
}
