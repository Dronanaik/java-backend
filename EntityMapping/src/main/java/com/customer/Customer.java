package com.customer;

import com.contact.Contact;
import com.deal.Deal;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String industry;

    // CUSTOMER → CONTACTS (ONE TO MANY)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();

    // CUSTOMER → DEALS (ONE TO MANY)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Deal> deals = new ArrayList<>();

    public Customer() {}

    public Customer(String name, String industry) {
        this.name = name;
        this.industry = industry;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Deal> getDeals() {
        return deals;
    }
}
