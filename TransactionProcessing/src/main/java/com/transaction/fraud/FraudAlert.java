package com.transaction.fraud;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.transaction.transaction.Transaction;

/**
 * Entity representing fraud alerts for flagged transactions
 */
@Entity
@Table(name = "fraud_alerts")
public class FraudAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "rule_id", nullable = false)
    private FraudRule rule;

    @Column(nullable = false)
    private LocalDateTime alertTime;

    @Column(nullable = false)
    private String severity; // LOW, MEDIUM, HIGH, CRITICAL

    @Column(nullable = false)
    private String status; // PENDING, REVIEWED, CONFIRMED, FALSE_POSITIVE

    @Column(length = 1000)
    private String reviewNotes;

    @PrePersist
    protected void onCreate() {
        alertTime = LocalDateTime.now();
        if (status == null) {
            status = "PENDING";
        }
    }

    // Constructors
    public FraudAlert() {
    }

    public FraudAlert(Transaction transaction, FraudRule rule, String severity) {
        this.transaction = transaction;
        this.rule = rule;
        this.severity = severity;
        this.status = "PENDING";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public FraudRule getRule() {
        return rule;
    }

    public void setRule(FraudRule rule) {
        this.rule = rule;
    }

    public LocalDateTime getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(LocalDateTime alertTime) {
        this.alertTime = alertTime;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReviewNotes() {
        return reviewNotes;
    }

    public void setReviewNotes(String reviewNotes) {
        this.reviewNotes = reviewNotes;
    }
}
