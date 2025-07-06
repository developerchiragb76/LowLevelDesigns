package org.example.notification.system.repository;

import org.example.notification.system.exceptions.NoNotificationTypeSubscribed;
import org.example.notification.system.exceptions.NotificationTypeAlreadySubscribedException;
import org.example.notification.system.exceptions.NotificationTypeNotExistForUnsubscription;
import org.example.notification.system.models.NotificationType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserNotificationRepository implements IUserNotificationRepository {
    private final Map<String, List<NotificationType>> userNotifcationMap;

    public InMemoryUserNotificationRepository() {
        userNotifcationMap = new HashMap<>();
    }

    @Override
    public List<NotificationType> getAllNotificationTypeForUser(String userId) {
        return userNotifcationMap.getOrDefault(userId, new ArrayList<>());
    }

    @Override
    public void addNotificationTypeForUser(String userId, NotificationType notificationType) throws NotificationTypeAlreadySubscribedException {
        userNotifcationMap.putIfAbsent(userId, new ArrayList<>());
        boolean present = userNotifcationMap.get(userId).contains(notificationType);
        if(present) {
            throw new NotificationTypeAlreadySubscribedException(userId, notificationType);
        }

        userNotifcationMap.get(userId).add(notificationType);
        System.out.println("Notification Type " + notificationType + " for user " + userId + " successfully added");
    }

    @Override
    public void removeNotificationTypeForUser(String userId, NotificationType notificationType) throws NotificationTypeNotExistForUnsubscription {
        List<NotificationType> notificationTypes = userNotifcationMap.getOrDefault(userId, new ArrayList<>());
        boolean contains = false;
        if(!notificationTypes.isEmpty()) {
            contains = notificationTypes.contains(notificationType);
            if(contains) {
                notificationTypes.remove(notificationType);
            }
        }

        if(!contains) {
            throw new NotificationTypeNotExistForUnsubscription(userId, notificationType);
        }
    }

    @Override
    public void unsubscribeNotificationService(String userId) throws NoNotificationTypeSubscribed {
        List<NotificationType> notificationTypes = userNotifcationMap.getOrDefault(userId, new ArrayList<>());
        if(notificationTypes.isEmpty()) {
            throw new NoNotificationTypeSubscribed(userId);
        }
        userNotifcationMap.put(userId, new ArrayList<>());
    }
}
