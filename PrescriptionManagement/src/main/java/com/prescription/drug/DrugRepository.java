package com.prescription.drug;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Drug entity
 */
@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

    Optional<Drug> findByName(String name);

    List<Drug> findByCategory(String category);

    List<Drug> findByNameContainingIgnoreCaseOrGenericNameContainingIgnoreCase(String name, String genericName);

    List<Drug> findByManufacturer(String manufacturer);
}
