package com.prescription.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prescription.allergy.AllergyService;
import com.prescription.drug.Drug;
import com.prescription.drug.DrugService;
import com.prescription.interaction.DrugInteraction;
import com.prescription.interaction.DrugInteractionService;
import com.prescription.patient.Patient;
import com.prescription.patient.PatientService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service implementation for Prescription operations
 * Implements all 5 key features:
 * 1. Drug Interaction Check
 * 2. Allergy Validation
 * 3. Dosage Calculation
 * 4. Refill Authorization
 * 5. Expiry Tracking
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private AllergyService allergyService;

    @Autowired
    private DrugInteractionService interactionService;

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found with id: " + id));
    }

    @Override
    public List<Prescription> getPrescriptionsByPatientId(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }

    @Override
    public List<Prescription> getPrescriptionsByStatus(Prescription.PrescriptionStatus status) {
        return prescriptionRepository.findByStatus(status);
    }

    @Override
    public List<Prescription> getExpiringPrescriptions(int daysAhead) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(daysAhead);
        return prescriptionRepository.findExpiringPrescriptions(today, futureDate);
    }

    @Override
    public List<Prescription> getPrescriptionsWithRefillsAvailable() {
        return prescriptionRepository.findPrescriptionsWithRefillsAvailable();
    }

    @Override
    public Prescription createPrescription(Prescription prescription) {
        // Validate before creating
        Map<String, Object> validation = validatePrescription(
                prescription.getPatient().getId(),
                prescription.getDrug().getId());

        if (!(Boolean) validation.get("isValid")) {
            throw new RuntimeException("Prescription validation failed: " + validation.get("warnings"));
        }

        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription updatePrescription(Long id, Prescription prescription) {
        Prescription existingPrescription = getPrescriptionById(id);

        existingPrescription.setDosage(prescription.getDosage());
        existingPrescription.setFrequency(prescription.getFrequency());
        existingPrescription.setStartDate(prescription.getStartDate());
        existingPrescription.setEndDate(prescription.getEndDate());
        existingPrescription.setExpiryDate(prescription.getExpiryDate());
        existingPrescription.setRefillsAllowed(prescription.getRefillsAllowed());
        existingPrescription.setRefillsRemaining(prescription.getRefillsRemaining());
        existingPrescription.setInstructions(prescription.getInstructions());
        existingPrescription.setStatus(prescription.getStatus());
        existingPrescription.setNotes(prescription.getNotes());

        return prescriptionRepository.save(existingPrescription);
    }

    @Override
    public void deletePrescription(Long id) {
        Prescription prescription = getPrescriptionById(id);
        prescriptionRepository.delete(prescription);
    }

    /**
     * Feature 1 & 2: Drug Interaction Check + Allergy Validation
     * Validates a prescription by checking for drug interactions and allergies
     */
    @Override
    public Map<String, Object> validatePrescription(Long patientId, Long drugId) {
        Map<String, Object> result = new HashMap<>();
        List<String> warnings = new ArrayList<>();
        boolean isValid = true;

        Patient patient = patientService.getPatientById(patientId);
        Drug drug = drugService.getDrugById(drugId);

        // Check for allergies (Feature 2: Allergy Validation)
        boolean hasAllergy = allergyService.checkAllergyConflict(patientId, drug.getName());
        if (hasAllergy) {
            warnings.add("⚠️ ALLERGY ALERT: Patient is allergic to " + drug.getName());
            isValid = false;
        }

        // Check for drug interactions (Feature 1: Drug Interaction Check)
        List<Prescription> activePrescrip = getPrescriptionsByPatientId(patientId);
        for (Prescription p : activePrescrip) {
            if (p.getStatus() == Prescription.PrescriptionStatus.ACTIVE) {
                List<DrugInteraction> interactions = interactionService.findInteractionsBetweenDrugs(
                        drugId, p.getDrug().getId());

                for (DrugInteraction interaction : interactions) {
                    String warning = String.format("⚠️ DRUG INTERACTION: %s with %s - Severity: %s - %s",
                            drug.getName(), p.getDrug().getName(),
                            interaction.getSeverityLevel(), interaction.getDescription());
                    warnings.add(warning);

                    if (interaction.getSeverityLevel() == DrugInteraction.InteractionSeverity.CONTRAINDICATED) {
                        isValid = false;
                    }
                }
            }
        }

        result.put("isValid", isValid);
        result.put("warnings", warnings);
        result.put("patient", patient.getName());
        result.put("drug", drug.getName());

        return result;
    }

    /**
     * Feature 3: Dosage Calculation
     * Calculates appropriate dosage based on patient age and weight
     */
    @Override
    public String calculateDosage(Long patientId, Long drugId, String baseDosage) {
        Patient patient = patientService.getPatientById(patientId);
        Drug drug = drugService.getDrugById(drugId);

        // Extract numeric value from base dosage (e.g., "500mg" -> 500)
        String numericPart = baseDosage.replaceAll("[^0-9.]", "");
        double baseAmount = Double.parseDouble(numericPart);
        String unit = baseDosage.replaceAll("[0-9.]", "");

        // Dosage calculation logic
        double calculatedDosage = baseAmount;

        // Adjust for age (children and elderly)
        if (patient.getAge() < 12) {
            // Children: reduce dosage by 50%
            calculatedDosage = baseAmount * 0.5;
        } else if (patient.getAge() > 65) {
            // Elderly: reduce dosage by 25%
            calculatedDosage = baseAmount * 0.75;
        }

        // Adjust for weight (if significantly different from average 70kg)
        double weightFactor = patient.getWeight() / 70.0;
        if (weightFactor < 0.7 || weightFactor > 1.3) {
            calculatedDosage = calculatedDosage * weightFactor;
        }

        return String.format("%.0f%s (Calculated for age: %d, weight: %.1fkg)",
                calculatedDosage, unit, patient.getAge(), patient.getWeight());
    }

    /**
     * Feature 4: Refill Authorization
     * Checks if prescription allows refills and processes refill request
     */
    @Override
    public Prescription authorizeRefill(Long prescriptionId) {
        Prescription prescription = getPrescriptionById(prescriptionId);

        // Check if prescription is active
        if (prescription.getStatus() != Prescription.PrescriptionStatus.ACTIVE) {
            throw new RuntimeException("Cannot refill: Prescription is not active (Status: " +
                    prescription.getStatus() + ")");
        }

        // Check if prescription has expired
        if (prescription.getExpiryDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot refill: Prescription has expired on " +
                    prescription.getExpiryDate());
        }

        // Check if refills are available
        if (prescription.getRefillsRemaining() <= 0) {
            throw new RuntimeException("Cannot refill: No refills remaining (Allowed: " +
                    prescription.getRefillsAllowed() + ", Used: " +
                    (prescription.getRefillsAllowed() - prescription.getRefillsRemaining()) + ")");
        }

        // Authorize refill
        prescription.setRefillsRemaining(prescription.getRefillsRemaining() - 1);
        prescription.setNotes(prescription.getNotes() + "\n[Refill authorized on " +
                LocalDate.now() + "]");

        return prescriptionRepository.save(prescription);
    }

    /**
     * Feature 5: Expiry Tracking
     * Alerts about expiring prescriptions for a patient
     */
    @Override
    public List<Prescription> checkExpiringPrescriptions(Long patientId, int daysAhead) {
        List<Prescription> allPrescriptions = getPrescriptionsByPatientId(patientId);
        List<Prescription> expiringPrescriptions = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(daysAhead);

        for (Prescription p : allPrescriptions) {
            if (p.getStatus() == Prescription.PrescriptionStatus.ACTIVE) {
                LocalDate expiryDate = p.getExpiryDate();
                if (expiryDate != null && !expiryDate.isBefore(today) && !expiryDate.isAfter(futureDate)) {
                    expiringPrescriptions.add(p);
                }
            }
        }

        return expiringPrescriptions;
    }
}
