package com.transaction.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for FraudRule entity
 */
@Repository
public interface FraudRuleRepository extends JpaRepository<FraudRule, Long> {

    List<FraudRule> findByIsActive(Boolean isActive);

    List<FraudRule> findByRuleType(String ruleType);

    List<FraudRule> findBySeverity(String severity);

    List<FraudRule> findByRuleTypeAndIsActive(String ruleType, Boolean isActive);
}
