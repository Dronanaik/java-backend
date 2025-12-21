package com.note;

import com.deal.Deal;
import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    // MANY NOTES → ONE DEAL
    @ManyToOne
    @JoinColumn(name = "deal_id")
    private Deal deal;

    public Note() {}

    public Note(String message, Deal deal) {
        this.message = message;
        this.deal = deal;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }
}
