package com.prescription.allergy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prescription.patient.Patient;

import java.util.List;

/**
 * Repository interface for Allergy entity
 */
@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {

    List<Allergy> findByPatient(Patient patient);

    List<Allergy> findByPatientId(Long patientId);

    List<Allergy> findBySeverity(Allergy.SeverityLevel severity);

    List<Allergy> findByAllergenContainingIgnoreCase(String allergen);
}
