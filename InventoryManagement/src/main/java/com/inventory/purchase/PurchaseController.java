package com.inventory.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }

    @GetMapping("/order/{orderNumber}")
    public ResponseEntity<Purchase> getPurchaseByOrderNumber(@PathVariable String orderNumber) {
        return ResponseEntity.ok(purchaseService.getPurchaseByOrderNumber(orderNumber));
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Purchase>> getPurchasesBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(purchaseService.getPurchasesBySupplier(supplierId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Purchase>> getPurchasesByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(purchaseService.getPurchasesByProduct(productId));
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Purchase>> getPurchasesByWarehouse(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(purchaseService.getPurchasesByWarehouse(warehouseId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Purchase>> getPurchasesByStatus(@PathVariable Purchase.PurchaseStatus status) {
        return ResponseEntity.ok(purchaseService.getPurchasesByStatus(status));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Purchase>> getPurchasesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(purchaseService.getPurchasesByDateRange(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.createPurchase(purchase));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable Long id, @RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.updatePurchase(id, purchase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }
}
