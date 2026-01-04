package com.transaction.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Account entity
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByAccountHolderNameContaining(String name);

    List<Account> findByStatus(String status);

    List<Account> findByCurrency(String currency);

    List<Account> findByAccountType(String accountType);
}
