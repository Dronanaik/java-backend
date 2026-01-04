package com.transaction.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.account.Account;
import com.transaction.account.AccountService;
import com.transaction.transaction.Transaction;
import com.transaction.transaction.TransactionService;

import java.time.LocalDate;
import java.util.List;

/**
 * Service implementation for Bill Payment Scheduling
 * Feature 6: Bill Payment Scheduling - Recurring payment automation
 */
@Service
public class BillPaymentService {

    @Autowired
    private BillPaymentRepository billPaymentRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    // Standard CRUD
    public List<BillPayment> getAllBillPayments() {
        return billPaymentRepository.findAll();
    }

    public BillPayment getBillPaymentById(Long id) {
        return billPaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill payment not found with id: " + id));
    }

    public BillPayment scheduleBillPayment(BillPayment billPayment) {
        billPayment.setStatus("SCHEDULED");
        if ("RECURRING".equals(billPayment.getFrequency())) {
            billPayment.setNextPaymentDate(billPayment.getDueDate());
        }
        return billPaymentRepository.save(billPayment);
    }

    public BillPayment updateBillPayment(Long id, BillPayment billPaymentDetails) {
        BillPayment billPayment = getBillPaymentById(id);
        billPayment.setBillerName(billPaymentDetails.getBillerName());
        billPayment.setAmount(billPaymentDetails.getAmount());
        billPayment.setDueDate(billPaymentDetails.getDueDate());
        billPayment.setAutoPayEnabled(billPaymentDetails.getAutoPayEnabled());
        billPayment.setReminderDays(billPaymentDetails.getReminderDays());
        return billPaymentRepository.save(billPayment);
    }

    public void deleteBillPayment(Long id) {
        billPaymentRepository.deleteById(id);
    }

    // Feature 6: Process Due Bills
    public void processDueBills() {
        LocalDate today = LocalDate.now();
        List<BillPayment> dueBills = billPaymentRepository.findByStatusAndAutoPayEnabled("SCHEDULED", true);

        for (BillPayment bill : dueBills) {
            if (bill.getDueDate().isBefore(today.plusDays(1))) {
                processBillPayment(bill);
            }
        }
    }

    public BillPayment processBillPayment(BillPayment billPayment) {
        try {
            // Create transaction
            Transaction transaction = new Transaction();
            transaction.setTransactionType("PAYMENT");
            transaction.setFromAccount(billPayment.getAccount());
            transaction.setAmount(billPayment.getAmount());
            transaction.setCurrency(billPayment.getAccount().getCurrency());
            transaction.setDescription("Bill Payment: " + billPayment.getBillerName());

            transactionService.processTransaction(transaction);

            // Update bill payment
            billPayment.setStatus("PAID");
            billPayment.setLastPaymentDate(LocalDate.now());

            if ("RECURRING".equals(billPayment.getFrequency())) {
                billPayment.setNextPaymentDate(billPayment.getDueDate().plusMonths(1));
                billPayment.setDueDate(billPayment.getDueDate().plusMonths(1));
                billPayment.setStatus("SCHEDULED");
            }

            return billPaymentRepository.save(billPayment);
        } catch (Exception e) {
            billPayment.setStatus("FAILED");
            billPayment.setNotes("Payment failed: " + e.getMessage());
            return billPaymentRepository.save(billPayment);
        }
    }

    public List<BillPayment> getUpcomingBills(int daysAhead) {
        LocalDate futureDate = LocalDate.now().plusDays(daysAhead);
        return billPaymentRepository.findByDueDateBefore(futureDate);
    }

    public List<BillPayment> getBillsByAccount(Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return billPaymentRepository.findByAccount(account);
    }

    public void sendReminders(int daysAhead) {
        List<BillPayment> upcomingBills = getUpcomingBills(daysAhead);
        for (BillPayment bill : upcomingBills) {
            if (bill.getReminderDays() != null &&
                    bill.getDueDate().minusDays(bill.getReminderDays()).isBefore(LocalDate.now().plusDays(1))) {
                System.out.println("📧 Reminder: Bill payment due for " + bill.getBillerName() +
                        " on " + bill.getDueDate());
            }
        }
    }
}
