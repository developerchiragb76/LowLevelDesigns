package org.example.customer.issue.resolution.system.model;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private final String userEmail;

    public Customer(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
