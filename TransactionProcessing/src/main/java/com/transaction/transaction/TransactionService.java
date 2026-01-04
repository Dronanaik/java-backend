package com.transaction.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.account.Account;
import com.transaction.account.AccountService;
import com.transaction.currency.CurrencyService;
import com.transaction.fee.FeeService;
import com.transaction.fraud.FraudService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service implementation for Transaction operations
 * Feature 4: Transaction Reversal Logic
 * Feature 8: Transaction Fee Calculation
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private FraudService fraudService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private FeeService feeService;

    // Standard CRUD operations
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    public Transaction getTransactionByTransactionId(String transactionId) {
        return transactionRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + transactionId));
    }

    // Main transaction processing with all validations
    public Transaction processTransaction(Transaction transaction) {
        Account fromAccount = transaction.getFromAccount();

        // Feature 7: Insufficient Funds Check
        if (!accountService.checkSufficientFunds(fromAccount.getId(), transaction.getAmount())) {
            transaction.setStatus("FAILED");
            transaction.setDescription(transaction.getDescription() + " [FAILED: Insufficient funds]");
            return transactionRepository.save(transaction);
        }

        // Feature 1: Daily Transaction Limits
        if (!accountService.checkDailyLimit(fromAccount.getId(), transaction.getAmount())) {
            transaction.setStatus("FAILED");
            transaction.setDescription(transaction.getDescription() + " [FAILED: Daily limit exceeded]");
            return transactionRepository.save(transaction);
        }

        // Feature 8: Transaction Fee Calculation
        BigDecimal fee = feeService.calculateFee(transaction);
        transaction.setFee(fee);

        // Feature 3: Currency Conversion (if needed)
        if (transaction.getToAccount() != null &&
                !fromAccount.getCurrency().equals(transaction.getToAccount().getCurrency())) {
            BigDecimal convertedAmount = currencyService.convertCurrency(
                    transaction.getAmount(),
                    fromAccount.getCurrency(),
                    transaction.getToAccount().getCurrency());
            transaction.setConvertedAmount(convertedAmount);
            BigDecimal rate = currencyService.getLatestExchangeRate(
                    fromAccount.getCurrency(),
                    transaction.getToAccount().getCurrency());
            transaction.setExchangeRate(rate);
        }

        // Process the transaction
        BigDecimal totalDebit = transaction.getAmount().add(fee);
        accountService.updateBalance(fromAccount.getId(), totalDebit, "DEBIT");

        if (transaction.getToAccount() != null) {
            BigDecimal creditAmount = transaction.getConvertedAmount() != null ? transaction.getConvertedAmount()
                    : transaction.getAmount();
            accountService.updateBalance(transaction.getToAccount().getId(), creditAmount, "CREDIT");
        }

        transaction.setStatus("COMPLETED");
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Feature 2: Fraud Detection
        fraudService.detectFraud(savedTransaction);

        return savedTransaction;
    }

    // Feature 4: Transaction Reversal Logic
    public Transaction reverseTransaction(Long transactionId, String reason) {
        Transaction originalTransaction = getTransactionById(transactionId);

        if (!"COMPLETED".equals(originalTransaction.getStatus())) {
            throw new RuntimeException("Only completed transactions can be reversed");
        }

        // Create reversal transaction
        Transaction reversalTransaction = new Transaction();
        reversalTransaction.setTransactionType("REVERSAL");
        reversalTransaction.setFromAccount(originalTransaction.getToAccount());
        reversalTransaction.setToAccount(originalTransaction.getFromAccount());
        reversalTransaction.setAmount(originalTransaction.getAmount());
        reversalTransaction.setCurrency(originalTransaction.getCurrency());
        reversalTransaction.setDescription("Reversal of " + originalTransaction.getTransactionId() + ": " + reason);
        reversalTransaction.setStatus("COMPLETED");

        // Reverse the balances
        if (originalTransaction.getFromAccount() != null) {
            BigDecimal refundAmount = originalTransaction.getAmount().add(
                    originalTransaction.getFee() != null ? originalTransaction.getFee() : BigDecimal.ZERO);
            accountService.updateBalance(originalTransaction.getFromAccount().getId(), refundAmount, "CREDIT");
        }

        if (originalTransaction.getToAccount() != null) {
            BigDecimal debitAmount = originalTransaction.getConvertedAmount() != null
                    ? originalTransaction.getConvertedAmount()
                    : originalTransaction.getAmount();
            accountService.updateBalance(originalTransaction.getToAccount().getId(), debitAmount, "DEBIT");
        }

        // Update original transaction
        originalTransaction.setStatus("REVERSED");
        originalTransaction.setReversalReason(reason);
        transactionRepository.save(originalTransaction);

        return transactionRepository.save(reversalTransaction);
    }

    public List<Transaction> getTransactionsByAccount(Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return transactionRepository.findByAccount(account);
    }

    public List<Transaction> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }

    public List<Transaction> getTransactionsByType(String type) {
        return transactionRepository.findByTransactionType(type);
    }

    public List<Transaction> getTransactionsByDateRange(LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findByTimestampBetween(start, end);
    }
}
