package com.inventory.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Stock entity
 * Provides CRUD operations and custom queries for stock management
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByProductId(Long productId);

    List<Stock> findByWarehouseId(Long warehouseId);

    Optional<Stock> findByProductIdAndWarehouseIdAndBatchNumber(Long productId, Long warehouseId, String batchNumber);

    @Query("SELECT s FROM Stock s WHERE s.product.id = :productId AND s.warehouse.id = :warehouseId")
    List<Stock> findByProductAndWarehouse(@Param("productId") Long productId, @Param("warehouseId") Long warehouseId);

    @Query("SELECT s FROM Stock s WHERE s.expiryDate IS NOT NULL AND s.expiryDate <= :date")
    List<Stock> findExpiringBefore(@Param("date") LocalDate date);

    @Query("SELECT s FROM Stock s WHERE s.quantity < (SELECT p.reorderLevel FROM Product p WHERE p.id = s.product.id)")
    List<Stock> findLowStockItems();
}
