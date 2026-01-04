package com.transaction.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Fraud Detection operations
 */
@RestController
@RequestMapping("/api/fraud")
@CrossOrigin(origins = "*")
public class FraudController {

    @Autowired
    private FraudService fraudService;

    // Fraud Rules
    @GetMapping("/rules")
    public ResponseEntity<List<FraudRule>> getAllRules() {
        return ResponseEntity.ok(fraudService.getAllRules());
    }

    @GetMapping("/rules/{id}")
    public ResponseEntity<FraudRule> getRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(fraudService.getRuleById(id));
    }

    @PostMapping("/rules")
    public ResponseEntity<FraudRule> createRule(@RequestBody FraudRule rule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fraudService.createRule(rule));
    }

    @PutMapping("/rules/{id}")
    public ResponseEntity<FraudRule> updateRule(@PathVariable Long id, @RequestBody FraudRule rule) {
        return ResponseEntity.ok(fraudService.updateRule(id, rule));
    }

    @DeleteMapping("/rules/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        fraudService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }

    // Fraud Alerts
    @GetMapping("/alerts")
    public ResponseEntity<List<FraudAlert>> getAllAlerts() {
        return ResponseEntity.ok(fraudService.getAllAlerts());
    }

    @GetMapping("/alerts/pending")
    public ResponseEntity<List<FraudAlert>> getPendingAlerts() {
        return ResponseEntity.ok(fraudService.getPendingAlerts());
    }

    @PutMapping("/alerts/{id}/review")
    public ResponseEntity<FraudAlert> reviewAlert(
            @PathVariable Long id,
            @RequestParam String status,
            @RequestParam(required = false) String notes) {
        return ResponseEntity.ok(fraudService.reviewAlert(id, status, notes));
    }

    @GetMapping("/alerts/severity/{severity}")
    public ResponseEntity<List<FraudAlert>> getAlertsBySeverity(@PathVariable String severity) {
        return ResponseEntity.ok(fraudService.getAlertsBySeverity(severity));
    }
}
