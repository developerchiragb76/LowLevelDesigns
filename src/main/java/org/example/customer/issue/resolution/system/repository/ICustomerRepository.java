package org.example.customer.issue.resolution.system.repository;

import org.example.customer.issue.resolution.system.model.Customer;

public interface ICustomerRepository {
    Customer getCustomer(String customerEmail);
}
