package com.transaction.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.account.Account;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for BillPayment entity
 */
@Repository
public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {

    List<BillPayment> findByStatus(String status);

    List<BillPayment> findByAccount(Account account);

    List<BillPayment> findByDueDateBefore(LocalDate date);

    List<BillPayment> findByAutoPayEnabled(Boolean enabled);

    List<BillPayment> findByBillerName(String billerName);

    List<BillPayment> findByStatusAndAutoPayEnabled(String status, Boolean enabled);
}
