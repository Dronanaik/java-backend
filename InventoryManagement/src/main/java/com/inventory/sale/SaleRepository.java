package com.inventory.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Sale entity
 * Provides CRUD operations and custom queries for sales orders
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Optional<Sale> findBySalesOrderNumber(String salesOrderNumber);

    List<Sale> findByProductId(Long productId);

    List<Sale> findByWarehouseId(Long warehouseId);

    List<Sale> findByStatus(Sale.SaleStatus status);

    List<Sale> findByPaymentStatus(Sale.PaymentStatus paymentStatus);

    List<Sale> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

    List<Sale> findByCustomerNameContainingIgnoreCase(String customerName);
}
