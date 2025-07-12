package org.example.calendar.application.exception;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String ownerEmail) {
        super("User With Email " + ownerEmail + " Not Found");
    }
}
