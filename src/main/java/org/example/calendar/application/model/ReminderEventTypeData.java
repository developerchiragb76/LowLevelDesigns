package org.example.calendar.application.model;

public class ReminderEventTypeData implements IEventData {
    private String reminderTitle;

    public ReminderEventTypeData(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }
}
