package com.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer updated) {
        Customer existing = getCustomer(id);
        existing.setName(updated.getName());
        existing.setIndustry(updated.getIndustry());
        return repository.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
