package com.prescription.prescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prescription.patient.Patient;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Prescription entity
 */
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByPatient(Patient patient);

    List<Prescription> findByPatientId(Long patientId);

    List<Prescription> findByStatus(Prescription.PrescriptionStatus status);

    List<Prescription> findByPrescribedBy(String prescribedBy);

    @Query("SELECT p FROM Prescription p WHERE p.expiryDate BETWEEN :startDate AND :endDate")
    List<Prescription> findExpiringPrescriptions(@Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("SELECT p FROM Prescription p WHERE p.refillsRemaining > 0 AND p.status = 'ACTIVE'")
    List<Prescription> findPrescriptionsWithRefillsAvailable();
}
