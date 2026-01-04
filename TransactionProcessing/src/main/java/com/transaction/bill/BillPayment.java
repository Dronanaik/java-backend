package com.transaction.bill;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.transaction.account.Account;

/**
 * Entity representing bill payment scheduling
 */
@Entity
@Table(name = "bill_payments")
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private String billerName;

    @Column(nullable = false)
    private String billerCode;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String frequency; // ONE_TIME, RECURRING

    @Column(nullable = false)
    private String status; // SCHEDULED, PAID, FAILED, CANCELLED

    private Integer reminderDays;

    @Column(nullable = false)
    private Boolean autoPayEnabled;

    private LocalDate lastPaymentDate;

    private LocalDate nextPaymentDate;

    @Column(length = 500)
    private String notes;

    // Constructors
    public BillPayment() {
        this.autoPayEnabled = false;
    }

    public BillPayment(Account account, String billerName, String billerCode,
            BigDecimal amount, LocalDate dueDate, String frequency) {
        this.account = account;
        this.billerName = billerName;
        this.billerCode = billerCode;
        this.amount = amount;
        this.dueDate = dueDate;
        this.frequency = frequency;
        this.status = "SCHEDULED";
        this.autoPayEnabled = false;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public String getBillerCode() {
        return billerCode;
    }

    public void setBillerCode(String billerCode) {
        this.billerCode = billerCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getReminderDays() {
        return reminderDays;
    }

    public void setReminderDays(Integer reminderDays) {
        this.reminderDays = reminderDays;
    }

    public Boolean getAutoPayEnabled() {
        return autoPayEnabled;
    }

    public void setAutoPayEnabled(Boolean autoPayEnabled) {
        this.autoPayEnabled = autoPayEnabled;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public LocalDate getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(LocalDate nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
