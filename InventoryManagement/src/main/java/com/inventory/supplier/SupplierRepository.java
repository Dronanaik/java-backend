package com.inventory.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Supplier entity
 * Provides CRUD operations and custom queries for suppliers
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByCode(String code);

    List<Supplier> findByIsActive(Boolean isActive);

    List<Supplier> findByNameContainingIgnoreCase(String name);

    List<Supplier> findByRating(Integer rating);
}
