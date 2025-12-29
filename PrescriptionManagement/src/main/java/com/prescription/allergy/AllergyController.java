package com.prescription.allergy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Allergy operations
 */
@RestController
@RequestMapping("/api/allergies")
@CrossOrigin(origins = "*")
public class AllergyController {

    @Autowired
    private AllergyService allergyService;

    @GetMapping
    public ResponseEntity<List<Allergy>> getAllAllergies() {
        return ResponseEntity.ok(allergyService.getAllAllergies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Allergy> getAllergyById(@PathVariable Long id) {
        return ResponseEntity.ok(allergyService.getAllergyById(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Allergy>> getAllergiesByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(allergyService.getAllergiesByPatientId(patientId));
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<Allergy>> getAllergiesBySeverity(@PathVariable Allergy.SeverityLevel severity) {
        return ResponseEntity.ok(allergyService.getAllergiesBySeverity(severity));
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkAllergyConflict(
            @RequestParam Long patientId,
            @RequestParam String drugName) {
        return ResponseEntity.ok(allergyService.checkAllergyConflict(patientId, drugName));
    }

    @PostMapping
    public ResponseEntity<Allergy> createAllergy(@RequestBody Allergy allergy) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(allergyService.createAllergy(allergy));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Allergy> updateAllergy(@PathVariable Long id, @RequestBody Allergy allergy) {
        return ResponseEntity.ok(allergyService.updateAllergy(id, allergy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllergy(@PathVariable Long id) {
        allergyService.deleteAllergy(id);
        return ResponseEntity.noContent().build();
    }
}
