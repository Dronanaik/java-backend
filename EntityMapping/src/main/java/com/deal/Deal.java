package com.deal;

import com.customer.Customer;
import com.note.Note;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dealName;
    private Double value;
    private String stage;

    // MANY DEALS → ONE CUSTOMER
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // DEAL → NOTES (ONE TO MANY)
    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();

    public Deal() {}

    public Deal(String dealName, Double value, String stage, Customer customer) {
        this.dealName = dealName;
        this.value = value;
        this.stage = stage;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Note> getNotes() {
        return notes;
    }
}
