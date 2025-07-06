package org.example.splitwise.exceptions;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String userId) {
        super("User with " + userId + " not found");
    }
}
