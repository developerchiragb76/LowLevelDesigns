package org.example.notification.system.models;

public class FriendRequestNotificationData implements INotificationData {
    private final String senderName;

    public FriendRequestNotificationData(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }

    @Override
    public String formatMessage(User user) {
        return "Hey " + user.getUserId() + ", you received a friend request from " + senderName + "!";
    }
}
