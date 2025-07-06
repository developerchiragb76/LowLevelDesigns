package org.example.notification.system.exceptions;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String userId) {
        System.out.println("User With " + userId + " Not Found");
    }
}
