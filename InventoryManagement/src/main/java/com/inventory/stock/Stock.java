package com.inventory.stock;

import com.inventory.product.Product;
import com.inventory.warehouse.Warehouse;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Stock Entity - Represents inventory stock levels in warehouses
 * 
 * Features:
 * - Product and warehouse relationship
 * - Quantity tracking
 * - Batch and lot number tracking
 * - Expiry date management
 * - Valuation method (FIFO/LIFO)
 */
@Entity
@Table(name = "stocks", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "product_id", "warehouse_id", "batch_number" })
})
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @Column(nullable = false)
    private Integer quantity = 0;

    private String batchNumber;

    private String lotNumber;

    private LocalDate expiryDate;

    private LocalDate manufacturingDate;

    @Enumerated(EnumType.STRING)
    private ValuationMethod valuationMethod = ValuationMethod.FIFO;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Enum for valuation methods
    public enum ValuationMethod {
        FIFO, // First In First Out
        LIFO, // Last In First Out
        AVERAGE // Weighted Average
    }

    // Constructors
    public Stock() {
    }

    public Stock(Product product, Warehouse warehouse, Integer quantity, String batchNumber,
            String lotNumber, LocalDate expiryDate, LocalDate manufacturingDate,
            ValuationMethod valuationMethod) {
        this.product = product;
        this.warehouse = warehouse;
        this.quantity = quantity;
        this.batchNumber = batchNumber;
        this.lotNumber = lotNumber;
        this.expiryDate = expiryDate;
        this.manufacturingDate = manufacturingDate;
        this.valuationMethod = valuationMethod;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public ValuationMethod getValuationMethod() {
        return valuationMethod;
    }

    public void setValuationMethod(ValuationMethod valuationMethod) {
        this.valuationMethod = valuationMethod;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", batchNumber='" + batchNumber + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
