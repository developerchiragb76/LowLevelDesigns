package org.example.notification.system.strategy;

import org.example.notification.system.exceptions.NotificationTypeNotSubscribedForUser;
import org.example.notification.system.models.Notification;
import org.example.notification.system.models.User;


public interface INotificationSendStrategy {
    void send(User user, Notification notification) throws NotificationTypeNotSubscribedForUser;
}
