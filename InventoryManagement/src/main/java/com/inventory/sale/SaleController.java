package com.inventory.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @GetMapping("/order/{orderNumber}")
    public ResponseEntity<Sale> getSaleByOrderNumber(@PathVariable String orderNumber) {
        return ResponseEntity.ok(saleService.getSaleByOrderNumber(orderNumber));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Sale>> getSalesByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(saleService.getSalesByProduct(productId));
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Sale>> getSalesByWarehouse(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(saleService.getSalesByWarehouse(warehouseId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Sale>> getSalesByStatus(@PathVariable Sale.SaleStatus status) {
        return ResponseEntity.ok(saleService.getSalesByStatus(status));
    }

    @GetMapping("/payment-status/{paymentStatus}")
    public ResponseEntity<List<Sale>> getSalesByPaymentStatus(@PathVariable Sale.PaymentStatus paymentStatus) {
        return ResponseEntity.ok(saleService.getSalesByPaymentStatus(paymentStatus));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Sale>> getSalesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(saleService.getSalesByDateRange(startDate, endDate));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Sale>> searchSalesByCustomer(@RequestParam String name) {
        return ResponseEntity.ok(saleService.searchSalesByCustomerName(name));
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.createSale(sale));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        return ResponseEntity.ok(saleService.updateSale(id, sale));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
