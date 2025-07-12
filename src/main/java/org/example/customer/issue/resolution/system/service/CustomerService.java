package org.example.customer.issue.resolution.system.service;

import org.example.customer.issue.resolution.system.model.Customer;
import org.example.customer.issue.resolution.system.repository.ICustomerRepository;

public class CustomerService {
    private ICustomerRepository customerRepository;

    public Customer getCustomer(String customerEmail) {
        return customerRepository.getCustomer(customerEmail);
    }
}
