package com.transaction.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.transaction.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service implementation for Account operations
 * Feature 1: Daily Transaction Limits
 * Feature 7: Insufficient Funds Check
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Standard CRUD operations
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNumber));
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account accountDetails) {
        Account account = getAccountById(id);
        account.setAccountHolderName(accountDetails.getAccountHolderName());
        account.setAccountType(accountDetails.getAccountType());
        account.setBalance(accountDetails.getBalance());
        account.setCurrency(accountDetails.getCurrency());
        account.setDailyLimit(accountDetails.getDailyLimit());
        account.setStatus(accountDetails.getStatus());
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    // Feature 1: Daily Transaction Limits
    public boolean checkDailyLimit(Long accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);

        if (account.getDailyLimit() == null) {
            return true; // No limit set
        }

        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        BigDecimal dailyTotal = transactionRepository.sumDailyTransactions(account, startOfDay);

        if (dailyTotal == null) {
            dailyTotal = BigDecimal.ZERO;
        }

        BigDecimal newTotal = dailyTotal.add(amount);
        return newTotal.compareTo(account.getDailyLimit()) <= 0;
    }

    public BigDecimal getDailyTransactionSum(Long accountId) {
        Account account = getAccountById(accountId);
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        BigDecimal sum = transactionRepository.sumDailyTransactions(account, startOfDay);
        return sum != null ? sum : BigDecimal.ZERO;
    }

    // Feature 7: Insufficient Funds Check
    public boolean checkSufficientFunds(Long accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);
        return account.getBalance().compareTo(amount) >= 0;
    }

    public void updateBalance(Long accountId, BigDecimal amount, String operation) {
        Account account = getAccountById(accountId);

        if ("DEBIT".equals(operation)) {
            account.setBalance(account.getBalance().subtract(amount));
        } else if ("CREDIT".equals(operation)) {
            account.setBalance(account.getBalance().add(amount));
        }

        accountRepository.save(account);
    }

    public List<Account> searchAccounts(String name) {
        return accountRepository.findByAccountHolderNameContaining(name);
    }

    public List<Account> getAccountsByStatus(String status) {
        return accountRepository.findByStatus(status);
    }

    public List<Account> getAccountsByCurrency(String currency) {
        return accountRepository.findByCurrency(currency);
    }
}
