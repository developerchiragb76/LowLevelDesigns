package org.example.notification.system.strategy;

import org.example.notification.system.exceptions.NotificationTypeNotSubscribedForUser;
import org.example.notification.system.models.Notification;
import org.example.notification.system.models.NotificationType;
import org.example.notification.system.models.User;
import org.example.notification.system.repository.IUserNotificationRepository;

import java.util.List;

public class SMSNotificationSendStrategy implements INotificationSendStrategy{
    private final IUserNotificationRepository userNotificationRepository;

    public SMSNotificationSendStrategy(IUserNotificationRepository userNotificationRepository) {
        this.userNotificationRepository = userNotificationRepository;
    }

    @Override
    public void send(User user, Notification notification) throws NotificationTypeNotSubscribedForUser {
        List<NotificationType> notificationTypeList = userNotificationRepository.getAllNotificationTypeForUser(user.getUserId());
        if(notificationTypeList.isEmpty() || !notificationTypeList.contains(notification.getNotificationType())) {
            throw new NotificationTypeNotSubscribedForUser(user, notification.getNotificationType());
        }

        String message = notification.getNotificationData().formatMessage(user);
        System.out.println("Sending SMS to " + user.getUserId() + ": " + message);
    }
}
