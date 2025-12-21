package com.customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomer(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Long id, Customer updated);

    void deleteCustomer(Long id);
}
