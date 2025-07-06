package org.example.notification.system.models;

public class NewMessageNotificationData implements INotificationData {
    private final String sender;
    private final String messageSnippet;

    public NewMessageNotificationData(String sender, String messageSnippet) {
        this.sender = sender;
        this.messageSnippet = messageSnippet;
    }


    @Override
    public String formatMessage(User user) {
        return "Hi " + user.getUserId() + ", " + sender + " sent you a message: \"" + messageSnippet + "\"";
    }
}
