package com.transaction.fee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.transaction.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Service implementation for Transaction Fee Calculation
 * Feature 8: Transaction Fee Calculation based on transaction type
 */
@Service
public class FeeService {

    @Autowired
    private TransactionFeeRuleRepository feeRuleRepository;

    // Fee Rule CRUD
    public List<TransactionFeeRule> getAllFeeRules() {
        return feeRuleRepository.findAll();
    }

    public TransactionFeeRule getFeeRuleById(Long id) {
        return feeRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fee rule not found with id: " + id));
    }

    public TransactionFeeRule createFeeRule(TransactionFeeRule rule) {
        return feeRuleRepository.save(rule);
    }

    public TransactionFeeRule updateFeeRule(Long id, TransactionFeeRule ruleDetails) {
        TransactionFeeRule rule = getFeeRuleById(id);
        rule.setTransactionType(ruleDetails.getTransactionType());
        rule.setFeeType(ruleDetails.getFeeType());
        rule.setFeeAmount(ruleDetails.getFeeAmount());
        rule.setFeePercentage(ruleDetails.getFeePercentage());
        rule.setMinAmount(ruleDetails.getMinAmount());
        rule.setMaxAmount(ruleDetails.getMaxAmount());
        rule.setIsActive(ruleDetails.getIsActive());
        return feeRuleRepository.save(rule);
    }

    public void deleteFeeRule(Long id) {
        feeRuleRepository.deleteById(id);
    }

    // Feature 8: Calculate Transaction Fee
    public BigDecimal calculateFee(Transaction transaction) {
        List<TransactionFeeRule> rules = feeRuleRepository.findByTransactionTypeAndIsActive(
                transaction.getTransactionType(), true);

        if (rules.isEmpty()) {
            return BigDecimal.ZERO;
        }

        TransactionFeeRule rule = rules.get(0); // Use first matching rule
        BigDecimal fee = BigDecimal.ZERO;

        switch (rule.getFeeType()) {
            case "FLAT":
                fee = rule.getFeeAmount();
                break;
            case "PERCENTAGE":
                fee = transaction.getAmount()
                        .multiply(rule.getFeePercentage())
                        .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
                break;
            case "TIERED":
                fee = calculateTieredFee(transaction.getAmount(), rule);
                break;
        }

        // Apply min/max limits
        if (rule.getMinAmount() != null && fee.compareTo(rule.getMinAmount()) < 0) {
            fee = rule.getMinAmount();
        }
        if (rule.getMaxAmount() != null && fee.compareTo(rule.getMaxAmount()) > 0) {
            fee = rule.getMaxAmount();
        }

        return fee;
    }

    private BigDecimal calculateTieredFee(BigDecimal amount, TransactionFeeRule rule) {
        // Simple tiered calculation - can be enhanced with multiple tiers
        if (amount.compareTo(new BigDecimal("1000")) <= 0) {
            return rule.getFeeAmount();
        } else {
            return amount.multiply(rule.getFeePercentage())
                    .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        }
    }

    public List<TransactionFeeRule> getFeeRulesByType(String transactionType) {
        return feeRuleRepository.findByTransactionType(transactionType);
    }
}
