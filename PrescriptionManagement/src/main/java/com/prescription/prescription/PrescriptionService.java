package com.prescription.prescription;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Service interface for Prescription operations
 */
public interface PrescriptionService {

    List<Prescription> getAllPrescriptions();

    Prescription getPrescriptionById(Long id);

    List<Prescription> getPrescriptionsByPatientId(Long patientId);

    List<Prescription> getPrescriptionsByStatus(Prescription.PrescriptionStatus status);

    List<Prescription> getExpiringPrescriptions(int daysAhead);

    List<Prescription> getPrescriptionsWithRefillsAvailable();

    Prescription createPrescription(Prescription prescription);

    Prescription updatePrescription(Long id, Prescription prescription);

    void deletePrescription(Long id);

    // Special feature methods
    Map<String, Object> validatePrescription(Long patientId, Long drugId);

    String calculateDosage(Long patientId, Long drugId, String baseDosage);

    Prescription authorizeRefill(Long prescriptionId);

    List<Prescription> checkExpiringPrescriptions(Long patientId, int daysAhead);
}
