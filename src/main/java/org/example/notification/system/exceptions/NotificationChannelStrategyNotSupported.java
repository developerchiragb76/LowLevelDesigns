package org.example.notification.system.exceptions;

import org.example.notification.system.models.NotificationChannel;

public class NotificationChannelStrategyNotSupported extends Throwable {
    public NotificationChannelStrategyNotSupported(NotificationChannel channel) {
        System.out.println("Notification Channel " + channel + " Handler Not Exist");
    }
}
