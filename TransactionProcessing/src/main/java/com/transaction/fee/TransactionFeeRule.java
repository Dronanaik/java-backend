package com.transaction.fee;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entity representing transaction fee calculation rules
 */
@Entity
@Table(name = "transaction_fee_rules")
public class TransactionFeeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String transactionType; // WITHDRAWAL, TRANSFER, DEPOSIT, PAYMENT

    @Column(nullable = false)
    private String feeType; // FLAT, PERCENTAGE, TIERED

    @Column(precision = 10, scale = 2)
    private BigDecimal feeAmount;

    @Column(precision = 5, scale = 2)
    private BigDecimal feePercentage;

    @Column(precision = 15, scale = 2)
    private BigDecimal minAmount;

    @Column(precision = 15, scale = 2)
    private BigDecimal maxAmount;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(length = 500)
    private String description;

    // Constructors
    public TransactionFeeRule() {
        this.isActive = true;
    }

    public TransactionFeeRule(String transactionType, String feeType, BigDecimal feeAmount,
            BigDecimal feePercentage, String currency) {
        this.transactionType = transactionType;
        this.feeType = feeType;
        this.feeAmount = feeAmount;
        this.feePercentage = feePercentage;
        this.currency = currency;
        this.isActive = true;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public BigDecimal getFeePercentage() {
        return feePercentage;
    }

    public void setFeePercentage(BigDecimal feePercentage) {
        this.feePercentage = feePercentage;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
