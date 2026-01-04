package com.transaction.fraud;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Entity representing fraud detection rules
 */
@Entity
@Table(name = "fraud_rules")
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleName;

    @Column(nullable = false)
    private String ruleType; // AMOUNT_THRESHOLD, FREQUENCY, LOCATION, PATTERN

    @Column(precision = 15, scale = 2)
    private BigDecimal threshold;

    private Integer timeWindowMinutes;

    @Column(nullable = false)
    private String severity; // LOW, MEDIUM, HIGH, CRITICAL

    @Column(nullable = false)
    private Boolean isActive;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL)
    private List<FraudAlert> fraudAlerts;

    // Constructors
    public FraudRule() {
        this.isActive = true;
    }

    public FraudRule(String ruleName, String ruleType, BigDecimal threshold,
            Integer timeWindowMinutes, String severity, String description) {
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.threshold = threshold;
        this.timeWindowMinutes = timeWindowMinutes;
        this.severity = severity;
        this.description = description;
        this.isActive = true;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    public Integer getTimeWindowMinutes() {
        return timeWindowMinutes;
    }

    public void setTimeWindowMinutes(Integer timeWindowMinutes) {
        this.timeWindowMinutes = timeWindowMinutes;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
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

    public List<FraudAlert> getFraudAlerts() {
        return fraudAlerts;
    }

    public void setFraudAlerts(List<FraudAlert> fraudAlerts) {
        this.fraudAlerts = fraudAlerts;
    }
}
