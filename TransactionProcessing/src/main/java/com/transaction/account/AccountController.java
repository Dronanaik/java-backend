package com.transaction.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller for Account operations
 */
@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber));
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return ResponseEntity.ok(accountService.updateAccount(id, account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<Map<String, Object>> getBalance(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("accountNumber", account.getAccountNumber());
        response.put("balance", account.getBalance());
        response.put("currency", account.getCurrency());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/daily-limit-status")
    public ResponseEntity<Map<String, Object>> getDailyLimitStatus(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        BigDecimal dailySum = accountService.getDailyTransactionSum(id);
        BigDecimal remaining = account.getDailyLimit() != null ? account.getDailyLimit().subtract(dailySum) : null;

        Map<String, Object> response = new HashMap<>();
        response.put("dailyLimit", account.getDailyLimit());
        response.put("usedToday", dailySum);
        response.put("remaining", remaining);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Account>> searchAccounts(@RequestParam String name) {
        return ResponseEntity.ok(accountService.searchAccounts(name));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Account>> getAccountsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(accountService.getAccountsByStatus(status));
    }
}
