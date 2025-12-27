package com.inventory.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Transfer entity
 * Provides CRUD operations and custom queries for stock transfers
 */
@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    Optional<Transfer> findByTransferNumber(String transferNumber);

    List<Transfer> findByProductId(Long productId);

    List<Transfer> findByFromWarehouseId(Long warehouseId);

    List<Transfer> findByToWarehouseId(Long warehouseId);

    List<Transfer> findByStatus(Transfer.TransferStatus status);

    List<Transfer> findByTransferDateBetween(LocalDate startDate, LocalDate endDate);
}
