package com.transaction.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.transaction.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Transaction entity
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByTransactionId(String transactionId);

    List<Transaction> findByFromAccount(Account account);

    List<Transaction> findByToAccount(Account account);

    List<Transaction> findByStatus(String status);

    List<Transaction> findByTransactionType(String type);

    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.fromAccount = :account AND t.timestamp >= :startTime AND t.status = 'COMPLETED'")
    BigDecimal sumDailyTransactions(@Param("account") Account account, @Param("startTime") LocalDateTime startTime);

    @Query("SELECT t FROM Transaction t WHERE t.fromAccount = :account OR t.toAccount = :account ORDER BY t.timestamp DESC")
    List<Transaction> findByAccount(@Param("account") Account account);
}
