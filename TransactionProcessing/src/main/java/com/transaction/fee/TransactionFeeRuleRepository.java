package com.transaction.fee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for TransactionFeeRule entity
 */
@Repository
public interface TransactionFeeRuleRepository extends JpaRepository<TransactionFeeRule, Long> {

    List<TransactionFeeRule> findByTransactionType(String transactionType);

    List<TransactionFeeRule> findByIsActive(Boolean isActive);

    List<TransactionFeeRule> findByTransactionTypeAndIsActive(String transactionType, Boolean isActive);

    List<TransactionFeeRule> findByCurrency(String currency);
}
