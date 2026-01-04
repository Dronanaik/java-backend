package com.transaction.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.transaction.Transaction;

import java.util.List;

/**
 * Repository interface for FraudAlert entity
 */
@Repository
public interface FraudAlertRepository extends JpaRepository<FraudAlert, Long> {

    List<FraudAlert> findByStatus(String status);

    List<FraudAlert> findByTransaction(Transaction transaction);

    List<FraudAlert> findBySeverity(String severity);

    List<FraudAlert> findByRule(FraudRule rule);
}
