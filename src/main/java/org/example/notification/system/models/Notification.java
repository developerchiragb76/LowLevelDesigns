package org.example.notification.system.models;

import java.util.List;

public class Notification {
    private final String notificationId;
    private final INotificationData notificationData;
    private final NotificationType notificationType;
    private final List<NotificationChannel> notificationChannels;

    public Notification(String notificationId, INotificationData notificationData, NotificationType notificationType, List<NotificationChannel> notificationChannels) {
        this.notificationId = notificationId;
        this.notificationData = notificationData;
        this.notificationType = notificationType;
        this.notificationChannels = notificationChannels;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public INotificationData getNotificationData() {
        return notificationData;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public List<NotificationChannel> getNotificationChannels() {
        return notificationChannels;
    }
}
