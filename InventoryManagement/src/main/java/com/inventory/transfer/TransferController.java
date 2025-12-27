package com.inventory.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping
    public ResponseEntity<List<Transfer>> getAllTransfers() {
        return ResponseEntity.ok(transferService.getAllTransfers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transfer> getTransferById(@PathVariable Long id) {
        return ResponseEntity.ok(transferService.getTransferById(id));
    }

    @GetMapping("/number/{transferNumber}")
    public ResponseEntity<Transfer> getTransferByNumber(@PathVariable String transferNumber) {
        return ResponseEntity.ok(transferService.getTransferByNumber(transferNumber));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Transfer>> getTransfersByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(transferService.getTransfersByProduct(productId));
    }

    @GetMapping("/from-warehouse/{warehouseId}")
    public ResponseEntity<List<Transfer>> getTransfersByFromWarehouse(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(transferService.getTransfersByFromWarehouse(warehouseId));
    }

    @GetMapping("/to-warehouse/{warehouseId}")
    public ResponseEntity<List<Transfer>> getTransfersByToWarehouse(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(transferService.getTransfersByToWarehouse(warehouseId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Transfer>> getTransfersByStatus(@PathVariable Transfer.TransferStatus status) {
        return ResponseEntity.ok(transferService.getTransfersByStatus(status));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Transfer>> getTransfersByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(transferService.getTransfersByDateRange(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<Transfer> createTransfer(@RequestBody Transfer transfer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transferService.createTransfer(transfer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transfer> updateTransfer(@PathVariable Long id, @RequestBody Transfer transfer) {
        return ResponseEntity.ok(transferService.updateTransfer(id, transfer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransfer(@PathVariable Long id) {
        transferService.deleteTransfer(id);
        return ResponseEntity.noContent().build();
    }
}
