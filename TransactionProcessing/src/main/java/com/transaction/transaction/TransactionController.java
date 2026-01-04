package com.transaction.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST Controller for Transaction operations
 */
@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @GetMapping("/txn/{transactionId}")
    public ResponseEntity<Transaction> getTransactionByTransactionId(@PathVariable String transactionId) {
        return ResponseEntity.ok(transactionService.getTransactionByTransactionId(transactionId));
    }

    @PostMapping("/process")
    public ResponseEntity<Transaction> processTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transactionService.processTransaction(transaction));
    }

    @PostMapping("/{id}/reverse")
    public ResponseEntity<Transaction> reverseTransaction(
            @PathVariable Long id,
            @RequestParam String reason) {
        return ResponseEntity.ok(transactionService.reverseTransaction(id, reason));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccount(accountId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Transaction>> getTransactionsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(transactionService.getTransactionsByStatus(status));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Transaction>> getTransactionsByType(@PathVariable String type) {
        return ResponseEntity.ok(transactionService.getTransactionsByType(type));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Transaction>> getTransactionsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(transactionService.getTransactionsByDateRange(start, end));
    }
}
