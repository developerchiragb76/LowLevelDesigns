package org.example.notification.system.service;

import org.example.notification.system.exceptions.*;
import org.example.notification.system.models.Notification;
import org.example.notification.system.models.NotificationChannel;
import org.example.notification.system.models.NotificationType;
import org.example.notification.system.models.User;
import org.example.notification.system.repository.IUserNotificationRepository;
import org.example.notification.system.repository.IUserRepository;
import org.example.notification.system.strategy.INotificationSendStrategy;

import java.util.List;
import java.util.Map;

public class NotificationService {
    private final IUserNotificationRepository userNotificationRepository;
    private final Map<NotificationChannel, INotificationSendStrategy> notificationSendStrategyMap;

    public NotificationService(IUserNotificationRepository userNotificationRepository, IUserRepository userRepository, Map<NotificationChannel, INotificationSendStrategy> notificationSendStrategyMap) {
        this.userNotificationRepository = userNotificationRepository;
        this.notificationSendStrategyMap = notificationSendStrategyMap;
    }

    public void subscribeToNotificationType(User user, NotificationType notificationType) throws NotificationTypeAlreadySubscribedException {
        userNotificationRepository.addNotificationTypeForUser(user.getUserId(), notificationType);
    }

    public void unsubscribeNotificationType(User user, NotificationType notificationType) throws NotificationTypeNotExistForUnsubscription {
        userNotificationRepository.removeNotificationTypeForUser(user.getUserId(), notificationType);
    }

    public void sendNotification(User user, Notification notification) throws NotificationChannelStrategyNotSupported, NotificationTypeNotSubscribedForUser {
        List<NotificationChannel> channelsToSend = notification.getNotificationChannels();
        for(NotificationChannel channel : channelsToSend) {
            INotificationSendStrategy sendStrategy = notificationSendStrategyMap.getOrDefault(channel, null);
            if(sendStrategy == null) {
                throw new NotificationChannelStrategyNotSupported(channel);
            }
            sendStrategy.send(user, notification);
        }
    }

    public void unsubscribeNotificationService(User user) throws NoNotificationTypeSubscribed {
        userNotificationRepository.unsubscribeNotificationService(user.getUserId());
    }
}
