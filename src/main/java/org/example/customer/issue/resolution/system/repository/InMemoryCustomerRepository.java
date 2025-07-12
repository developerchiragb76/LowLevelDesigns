package org.example.customer.issue.resolution.system.repository;

import org.example.customer.issue.resolution.system.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCustomerRepository implements ICustomerRepository {
    private final Map<String, Customer> customerMap;

    public InMemoryCustomerRepository() {
        customerMap = new HashMap<>();
    }

    @Override
    public Customer getCustomer(String customerEmail) {
        return customerMap.getOrDefault(customerEmail, null);
    }
}
