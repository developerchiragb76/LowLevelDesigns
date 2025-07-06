package org.example.ride.sharing.application.exception;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String userId) {
        super("User With " + userId + " Not Found");
    }
}
