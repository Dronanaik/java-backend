package com.transaction.account;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.transaction.transaction.Transaction;
import com.transaction.standing.StandingInstruction;
import com.transaction.bill.BillPayment;

/**
 * Entity representing a bank account
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private String accountType; // SAVINGS, CURRENT, FIXED

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal balance;

    @Column(nullable = false)
    private String currency; // USD, EUR, INR, etc.

    @Column(precision = 15, scale = 2)
    private BigDecimal dailyLimit;

    @Column(nullable = false)
    private String status; // ACTIVE, FROZEN, CLOSED

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL)
    private List<Transaction> outgoingTransactions;

    @OneToMany(mappedBy = "toAccount", cascade = CascadeType.ALL)
    private List<Transaction> incomingTransactions;

    @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL)
    private List<StandingInstruction> standingInstructions;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<BillPayment> billPayments;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) {
            status = "ACTIVE";
        }
        if (balance == null) {
            balance = BigDecimal.ZERO;
        }
    }

    // Constructors
    public Account() {
    }

    public Account(String accountNumber, String accountHolderName, String accountType,
            BigDecimal balance, String currency, BigDecimal dailyLimit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = currency;
        this.dailyLimit = dailyLimit;
        this.status = "ACTIVE";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(BigDecimal dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Transaction> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public void setOutgoingTransactions(List<Transaction> outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public List<Transaction> getIncomingTransactions() {
        return incomingTransactions;
    }

    public void setIncomingTransactions(List<Transaction> incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }

    public List<StandingInstruction> getStandingInstructions() {
        return standingInstructions;
    }

    public void setStandingInstructions(List<StandingInstruction> standingInstructions) {
        this.standingInstructions = standingInstructions;
    }

    public List<BillPayment> getBillPayments() {
        return billPayments;
    }

    public void setBillPayments(List<BillPayment> billPayments) {
        this.billPayments = billPayments;
    }
}
