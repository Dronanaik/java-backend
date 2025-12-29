package com.prescription.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST Controller for Prescription operations
 * Exposes all 5 key features via REST endpoints
 */
@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionService.getAllPrescriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionById(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsByPatientId(patientId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByStatus(
            @PathVariable Prescription.PrescriptionStatus status) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsByStatus(status));
    }

    @GetMapping("/expiring")
    public ResponseEntity<List<Prescription>> getExpiringPrescriptions(@RequestParam int daysAhead) {
        return ResponseEntity.ok(prescriptionService.getExpiringPrescriptions(daysAhead));
    }

    @GetMapping("/refills-available")
    public ResponseEntity<List<Prescription>> getPrescriptionsWithRefills() {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsWithRefillsAvailable());
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(prescriptionService.createPrescription(prescription));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(
            @PathVariable Long id,
            @RequestBody Prescription prescription) {
        return ResponseEntity.ok(prescriptionService.updatePrescription(id, prescription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }

    // ========== SPECIAL FEATURE ENDPOINTS ==========

    /**
     * Feature 1 & 2: Validate prescription (Drug Interaction + Allergy Check)
     */
    @PostMapping("/validate")
    public ResponseEntity<Map<String, Object>> validatePrescription(
            @RequestParam Long patientId,
            @RequestParam Long drugId) {
        return ResponseEntity.ok(prescriptionService.validatePrescription(patientId, drugId));
    }

    /**
     * Feature 3: Calculate dosage based on patient age and weight
     */
    @PostMapping("/calculate-dosage")
    public ResponseEntity<String> calculateDosage(
            @RequestParam Long patientId,
            @RequestParam Long drugId,
            @RequestParam String baseDosage) {
        return ResponseEntity.ok(prescriptionService.calculateDosage(patientId, drugId, baseDosage));
    }

    /**
     * Feature 4: Authorize refill
     */
    @PostMapping("/{id}/refill")
    public ResponseEntity<Prescription> authorizeRefill(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.authorizeRefill(id));
    }

    /**
     * Feature 5: Check expiring prescriptions for a patient
     */
    @GetMapping("/patient/{patientId}/expiring")
    public ResponseEntity<List<Prescription>> checkExpiringPrescriptions(
            @PathVariable Long patientId,
            @RequestParam int daysAhead) {
        return ResponseEntity.ok(prescriptionService.checkExpiringPrescriptions(patientId, daysAhead));
    }
}
