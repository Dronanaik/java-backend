package com.transaction.standing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.account.Account;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for StandingInstruction entity
 */
@Repository
public interface StandingInstructionRepository extends JpaRepository<StandingInstruction, Long> {

    List<StandingInstruction> findByStatus(String status);

    List<StandingInstruction> findByNextExecutionBefore(LocalDate date);

    List<StandingInstruction> findByFromAccount(Account account);

    List<StandingInstruction> findByToAccount(Account account);

    List<StandingInstruction> findByStatusAndNextExecutionBefore(String status, LocalDate date);
}
