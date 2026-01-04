package com.transaction.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.account.Account;
import com.transaction.transaction.Transaction;
import com.transaction.transaction.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service implementation for Fraud Detection
 * Feature 2: Fraud Detection Rules
 */
@Service
public class FraudService {

    @Autowired
    private FraudRuleRepository fraudRuleRepository;

    @Autowired
    private FraudAlertRepository fraudAlertRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Fraud Rule CRUD
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll();
    }

    public FraudRule getRuleById(Long id) {
        return fraudRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fraud rule not found with id: " + id));
    }

    public FraudRule createRule(FraudRule rule) {
        return fraudRuleRepository.save(rule);
    }

    public FraudRule updateRule(Long id, FraudRule ruleDetails) {
        FraudRule rule = getRuleById(id);
        rule.setRuleName(ruleDetails.getRuleName());
        rule.setRuleType(ruleDetails.getRuleType());
        rule.setThreshold(ruleDetails.getThreshold());
        rule.setTimeWindowMinutes(ruleDetails.getTimeWindowMinutes());
        rule.setSeverity(ruleDetails.getSeverity());
        rule.setIsActive(ruleDetails.getIsActive());
        rule.setDescription(ruleDetails.getDescription());
        return fraudRuleRepository.save(rule);
    }

    public void deleteRule(Long id) {
        fraudRuleRepository.deleteById(id);
    }

    // Feature 2: Fraud Detection
    public void detectFraud(Transaction transaction) {
        List<FraudRule> activeRules = fraudRuleRepository.findByIsActive(true);

        for (FraudRule rule : activeRules) {
            boolean isFraudulent = false;

            switch (rule.getRuleType()) {
                case "AMOUNT_THRESHOLD":
                    isFraudulent = checkAmountThreshold(transaction, rule);
                    break;
                case "FREQUENCY":
                    isFraudulent = checkFrequencyPattern(transaction, rule);
                    break;
                case "PATTERN":
                    isFraudulent = checkUnusualPattern(transaction, rule);
                    break;
            }

            if (isFraudulent) {
                flagTransaction(transaction, rule);
            }
        }
    }

    private boolean checkAmountThreshold(Transaction transaction, FraudRule rule) {
        return transaction.getAmount().compareTo(rule.getThreshold()) > 0;
    }

    private boolean checkFrequencyPattern(Transaction transaction, FraudRule rule) {
        Account account = transaction.getFromAccount();
        LocalDateTime timeWindow = LocalDateTime.now().minusMinutes(rule.getTimeWindowMinutes());

        List<Transaction> recentTransactions = transactionRepository.findByTimestampBetween(
                timeWindow, LocalDateTime.now());

        long accountTransactionCount = recentTransactions.stream()
                .filter(t -> t.getFromAccount().equals(account))
                .count();

        // Flag if more than 5 transactions in the time window
        return accountTransactionCount > 5;
    }

    private boolean checkUnusualPattern(Transaction transaction, FraudRule rule) {
        // Simple pattern check - can be enhanced with ML models
        return transaction.getAmount().compareTo(new BigDecimal("10000")) > 0 &&
                "WITHDRAWAL".equals(transaction.getTransactionType());
    }

    private void flagTransaction(Transaction transaction, FraudRule rule) {
        FraudAlert alert = new FraudAlert(transaction, rule, rule.getSeverity());
        fraudAlertRepository.save(alert);

        System.out.println("⚠️ FRAUD ALERT: Transaction " + transaction.getTransactionId() +
                " flagged by rule: " + rule.getRuleName());
    }

    // Fraud Alert operations
    public List<FraudAlert> getAllAlerts() {
        return fraudAlertRepository.findAll();
    }

    public List<FraudAlert> getPendingAlerts() {
        return fraudAlertRepository.findByStatus("PENDING");
    }

    public FraudAlert reviewAlert(Long alertId, String status, String notes) {
        FraudAlert alert = fraudAlertRepository.findById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found with id: " + alertId));

        alert.setStatus(status);
        alert.setReviewNotes(notes);
        return fraudAlertRepository.save(alert);
    }

    public List<FraudAlert> getAlertsBySeverity(String severity) {
        return fraudAlertRepository.findBySeverity(severity);
    }
}
