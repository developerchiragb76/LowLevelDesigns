package org.example.notification.system.exceptions;

import org.example.notification.system.models.NotificationType;

public class NotificationTypeNotExistForUnsubscription extends Throwable {
    public NotificationTypeNotExistForUnsubscription(String userId, NotificationType notificationType) {
        super("Notification Type " + notificationType + " not exist for userid " + userId);
    }
}
