package org.example.notification.system.repository;

import org.example.notification.system.exceptions.NoNotificationTypeSubscribed;
import org.example.notification.system.exceptions.NotificationTypeAlreadySubscribedException;
import org.example.notification.system.exceptions.NotificationTypeNotExistForUnsubscription;
import org.example.notification.system.models.NotificationType;

import java.util.List;

public interface IUserNotificationRepository {
    List<NotificationType> getAllNotificationTypeForUser(String userId);
    void addNotificationTypeForUser(String userId, NotificationType notificationType) throws NotificationTypeAlreadySubscribedException;
    void removeNotificationTypeForUser(String userId, NotificationType notificationType) throws NotificationTypeNotExistForUnsubscription;

    void unsubscribeNotificationService(String userId) throws NoNotificationTypeSubscribed;
}
