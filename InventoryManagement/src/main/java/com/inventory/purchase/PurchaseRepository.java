package com.inventory.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Purchase entity
 * Provides CRUD operations and custom queries for purchase orders
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    Optional<Purchase> findByPurchaseOrderNumber(String purchaseOrderNumber);

    List<Purchase> findBySupplierId(Long supplierId);

    List<Purchase> findByProductId(Long productId);

    List<Purchase> findByWarehouseId(Long warehouseId);

    List<Purchase> findByStatus(Purchase.PurchaseStatus status);

    List<Purchase> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
}
