package com.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return service.getCustomer(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return service.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "Customer deleted successfully!";
    }
}
