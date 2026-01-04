package com.transaction.fee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transaction.transaction.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller for Transaction Fee operations
 */
@RestController
@RequestMapping("/api/fees")
@CrossOrigin(origins = "*")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @GetMapping("/rules")
    public ResponseEntity<List<TransactionFeeRule>> getAllFeeRules() {
        return ResponseEntity.ok(feeService.getAllFeeRules());
    }

    @GetMapping("/rules/{id}")
    public ResponseEntity<TransactionFeeRule> getFeeRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(feeService.getFeeRuleById(id));
    }

    @PostMapping("/rules")
    public ResponseEntity<TransactionFeeRule> createFeeRule(@RequestBody TransactionFeeRule rule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feeService.createFeeRule(rule));
    }

    @PutMapping("/rules/{id}")
    public ResponseEntity<TransactionFeeRule> updateFeeRule(
            @PathVariable Long id,
            @RequestBody TransactionFeeRule rule) {
        return ResponseEntity.ok(feeService.updateFeeRule(id, rule));
    }

    @DeleteMapping("/rules/{id}")
    public ResponseEntity<Void> deleteFeeRule(@PathVariable Long id) {
        feeService.deleteFeeRule(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Object>> calculateFee(@RequestBody Transaction transaction) {
        BigDecimal fee = feeService.calculateFee(transaction);

        Map<String, Object> response = new HashMap<>();
        response.put("transactionType", transaction.getTransactionType());
        response.put("amount", transaction.getAmount());
        response.put("calculatedFee", fee);
        response.put("totalAmount", transaction.getAmount().add(fee));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/rules/type/{transactionType}")
    public ResponseEntity<List<TransactionFeeRule>> getFeeRulesByType(@PathVariable String transactionType) {
        return ResponseEntity.ok(feeService.getFeeRulesByType(transactionType));
    }
}
