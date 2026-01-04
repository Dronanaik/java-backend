package com.transaction.transaction;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.transaction.account.Account;
import com.transaction.fraud.FraudAlert;

/**
 * Entity representing a financial transaction
 */
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private String transactionType; // WITHDRAWAL, TRANSFER, DEPOSIT, PAYMENT

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String currency;

    @Column(precision = 10, scale = 6)
    private BigDecimal exchangeRate;

    @Column(precision = 15, scale = 2)
    private BigDecimal convertedAmount;

    @Column(nullable = false)
    private String status; // PENDING, COMPLETED, FAILED, REVERSED

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;

    @Column(length = 500)
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal fee;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(length = 500)
    private String reversalReason;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<FraudAlert> fraudAlerts;

    @PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
        if (status == null) {
            status = "PENDING";
        }
        if (transactionId == null) {
            transactionId = "TXN" + System.currentTimeMillis();
        }
    }

    // Constructors
    public Transaction() {
    }

    public Transaction(String transactionType, BigDecimal amount, String currency,
            Account fromAccount, Account toAccount, String description) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.description = description;
        this.status = "PENDING";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReversalReason() {
        return reversalReason;
    }

    public void setReversalReason(String reversalReason) {
        this.reversalReason = reversalReason;
    }

    public List<FraudAlert> getFraudAlerts() {
        return fraudAlerts;
    }

    public void setFraudAlerts(List<FraudAlert> fraudAlerts) {
        this.fraudAlerts = fraudAlerts;
    }
}
