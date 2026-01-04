package com.transaction.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Bill Payment operations
 */
@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillPaymentController {

    @Autowired
    private BillPaymentService billPaymentService;

    @GetMapping
    public ResponseEntity<List<BillPayment>> getAllBillPayments() {
        return ResponseEntity.ok(billPaymentService.getAllBillPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillPayment> getBillPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(billPaymentService.getBillPaymentById(id));
    }

    @PostMapping
    public ResponseEntity<BillPayment> scheduleBillPayment(@RequestBody BillPayment billPayment) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(billPaymentService.scheduleBillPayment(billPayment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillPayment> updateBillPayment(
            @PathVariable Long id,
            @RequestBody BillPayment billPayment) {
        return ResponseEntity.ok(billPaymentService.updateBillPayment(id, billPayment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillPayment(@PathVariable Long id) {
        billPaymentService.deleteBillPayment(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<BillPayment> processBillPayment(@PathVariable Long id) {
        BillPayment billPayment = billPaymentService.getBillPaymentById(id);
        return ResponseEntity.ok(billPaymentService.processBillPayment(billPayment));
    }

    @GetMapping("/due")
    public ResponseEntity<List<BillPayment>> getUpcomingBills(@RequestParam(defaultValue = "30") int daysAhead) {
        return ResponseEntity.ok(billPaymentService.getUpcomingBills(daysAhead));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<BillPayment>> getBillsByAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(billPaymentService.getBillsByAccount(accountId));
    }

    @PostMapping("/process-due")
    public ResponseEntity<String> processDueBills() {
        billPaymentService.processDueBills();
        return ResponseEntity.ok("Due bills processed successfully");
    }
}
