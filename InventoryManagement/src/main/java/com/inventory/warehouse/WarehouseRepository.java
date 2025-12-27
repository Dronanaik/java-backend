package com.inventory.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Warehouse entity
 * Provides CRUD operations and custom queries for warehouses
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Optional<Warehouse> findByCode(String code);

    List<Warehouse> findByIsActive(Boolean isActive);

    List<Warehouse> findByCity(String city);

    List<Warehouse> findByNameContainingIgnoreCase(String name);
}
