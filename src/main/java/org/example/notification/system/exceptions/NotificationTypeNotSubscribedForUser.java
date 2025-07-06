package org.example.notification.system.exceptions;

import org.example.notification.system.models.NotificationType;
import org.example.notification.system.models.User;

public class NotificationTypeNotSubscribedForUser extends Throwable {
    public NotificationTypeNotSubscribedForUser(User user, NotificationType notificationType) {
        super("Notification Type " + notificationType + " Not Subscribed For UserId " + user.getUserId());
    }
}
