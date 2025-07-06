package org.example.notification.system;

import org.example.notification.system.exceptions.NotificationChannelStrategyNotSupported;
import org.example.notification.system.exceptions.NotificationTypeAlreadySubscribedException;
import org.example.notification.system.exceptions.NotificationTypeNotExistForUnsubscription;
import org.example.notification.system.exceptions.NotificationTypeNotSubscribedForUser;
import org.example.notification.system.models.*;
import org.example.notification.system.repository.InMemoryUserNotificationRepository;
import org.example.notification.system.repository.InMemoryUserRepository;
import org.example.notification.system.service.NotificationService;
import org.example.notification.system.strategy.EmailNotificationSendStrategy;
import org.example.notification.system.strategy.INotificationSendStrategy;
import org.example.notification.system.strategy.SMSNotificationSendStrategy;

import java.util.List;
import java.util.Map;

public class NotificationSystemDriver {
    public static void main(String[] args) throws NotificationTypeNotSubscribedForUser, NotificationChannelStrategyNotSupported, NotificationTypeAlreadySubscribedException, NotificationTypeNotExistForUnsubscription {
        // Step 1: Setup repositories
        InMemoryUserRepository userRepo = new InMemoryUserRepository();
        InMemoryUserNotificationRepository userNotificationRepo = new InMemoryUserNotificationRepository();

        // Step 2: Register notification send strategies
        Map<NotificationChannel, INotificationSendStrategy> strategyMap = Map.of(
                NotificationChannel.EMAIL, new EmailNotificationSendStrategy(userNotificationRepo),
                NotificationChannel.SMS, new SMSNotificationSendStrategy(userNotificationRepo)
        );

        // Step 3: Create NotificationService
        NotificationService notificationService = new NotificationService(userNotificationRepo, userRepo, strategyMap);

        // Step 4: Add user
        User user = new User("chirag123");
        userRepo.saveUser(user);

        // Step 5: Subscribe to FRIEND_REQUESTS and NEW_MESSAGES
        notificationService.subscribeToNotificationType(user, NotificationType.FRIEND_REQUESTS);
        notificationService.subscribeToNotificationType(user, NotificationType.NEW_MESSAGES);

        // Step 6: Create and send a Friend Request Notification
        INotificationData friendData = new FriendRequestNotificationData("ramesh");
        Notification friendNotification = new Notification(
                "notif-101",
                friendData,
                NotificationType.FRIEND_REQUESTS,
                List.of(NotificationChannel.EMAIL)
        );
        notificationService.sendNotification(user, friendNotification);

        // Step 7: Create and send a New Message Notification
        INotificationData messageData = new NewMessageNotificationData("john", "Let's meet tomorrow!");
        Notification messageNotification = new Notification(
                "notif-102",
                messageData,
                NotificationType.NEW_MESSAGES,
                List.of(NotificationChannel.SMS)
        );
        notificationService.sendNotification(user, messageNotification);

        // Step 8: Unsubscribe and test again
        notificationService.unsubscribeNotificationType(user, NotificationType.NEW_MESSAGES);

        try {
            notificationService.sendNotification(user, messageNotification);
        } catch (NotificationTypeNotSubscribedForUser e) {
            System.out.println("Expected exception: " + e.getMessage());
        }
    }
}
