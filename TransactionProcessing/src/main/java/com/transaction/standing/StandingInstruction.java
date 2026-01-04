package com.transaction.standing;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.transaction.account.Account;

/**
 * Entity representing standing instructions for recurring transfers
 */
@Entity
@Table(name = "standing_instructions")
public class StandingInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_account_id", nullable = false)
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id", nullable = false)
    private Account toAccount;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String frequency; // DAILY, WEEKLY, MONTHLY, YEARLY

    private Integer executionDay; // Day of month (1-31) or day of week (1-7)

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @Column(nullable = false)
    private String status; // ACTIVE, PAUSED, COMPLETED, CANCELLED

    private LocalDate lastExecuted;

    private LocalDate nextExecution;

    @Column(length = 500)
    private String description;

    // Constructors
    public StandingInstruction() {
    }

    public StandingInstruction(Account fromAccount, Account toAccount, BigDecimal amount,
            String frequency, Integer executionDay, LocalDate startDate) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.frequency = frequency;
        this.executionDay = executionDay;
        this.startDate = startDate;
        this.status = "ACTIVE";
        this.nextExecution = calculateNextExecution();
    }

    private LocalDate calculateNextExecution() {
        // Simple calculation - can be enhanced
        return LocalDate.now().plusDays(1);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getExecutionDay() {
        return executionDay;
    }

    public void setExecutionDay(Integer executionDay) {
        this.executionDay = executionDay;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLastExecuted() {
        return lastExecuted;
    }

    public void setLastExecuted(LocalDate lastExecuted) {
        this.lastExecuted = lastExecuted;
    }

    public LocalDate getNextExecution() {
        return nextExecution;
    }

    public void setNextExecution(LocalDate nextExecution) {
        this.nextExecution = nextExecution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
