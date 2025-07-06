package org.example.notification.system.exceptions;

public class NoNotificationTypeSubscribed extends Throwable {
    public NoNotificationTypeSubscribed(String userId) {
        System.out.println("No Notification Type Subscribed For " + userId);
    }
}
