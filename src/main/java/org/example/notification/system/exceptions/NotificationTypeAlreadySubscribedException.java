package org.example.notification.system.exceptions;

import org.example.notification.system.models.NotificationType;

public class NotificationTypeAlreadySubscribedException extends Throwable {
    public NotificationTypeAlreadySubscribedException(String userId, NotificationType notificationType) {
        super("User with " + userId + " already subscribed to " + notificationType);
    }
}
