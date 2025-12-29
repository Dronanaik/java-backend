package com.prescription.interaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prescription.drug.Drug;

import java.util.List;

/**
 * Repository interface for DrugInteraction entity
 */
@Repository
public interface DrugInteractionRepository extends JpaRepository<DrugInteraction, Long> {

    List<DrugInteraction> findBySeverityLevel(DrugInteraction.InteractionSeverity severity);

    @Query("SELECT di FROM DrugInteraction di WHERE (di.drug1.id = :drugId1 AND di.drug2.id = :drugId2) OR (di.drug1.id = :drugId2 AND di.drug2.id = :drugId1)")
    List<DrugInteraction> findInteractionsBetweenDrugs(@Param("drugId1") Long drugId1, @Param("drugId2") Long drugId2);

    @Query("SELECT di FROM DrugInteraction di WHERE di.drug1.id = :drugId OR di.drug2.id = :drugId")
    List<DrugInteraction> findInteractionsByDrugId(@Param("drugId") Long drugId);
}
