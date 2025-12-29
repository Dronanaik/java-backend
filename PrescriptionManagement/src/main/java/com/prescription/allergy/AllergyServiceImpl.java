package com.prescription.allergy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Allergy operations
 * Implements Allergy Validation feature
 */
@Service
public class AllergyServiceImpl implements AllergyService {

    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public List<Allergy> getAllAllergies() {
        return allergyRepository.findAll();
    }

    @Override
    public Allergy getAllergyById(Long id) {
        return allergyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allergy not found with id: " + id));
    }

    @Override
    public List<Allergy> getAllergiesByPatientId(Long patientId) {
        return allergyRepository.findByPatientId(patientId);
    }

    @Override
    public List<Allergy> getAllergiesBySeverity(Allergy.SeverityLevel severity) {
        return allergyRepository.findBySeverity(severity);
    }

    @Override
    public boolean checkAllergyConflict(Long patientId, String drugName) {
        List<Allergy> patientAllergies = allergyRepository.findByPatientId(patientId);

        // Check if any patient allergy matches the drug name or contains it
        for (Allergy allergy : patientAllergies) {
            if (drugName.toLowerCase().contains(allergy.getAllergen().toLowerCase()) ||
                    allergy.getAllergen().toLowerCase().contains(drugName.toLowerCase())) {
                return true; // Conflict found
            }
        }

        return false; // No conflict
    }

    @Override
    public Allergy createAllergy(Allergy allergy) {
        return allergyRepository.save(allergy);
    }

    @Override
    public Allergy updateAllergy(Long id, Allergy allergy) {
        Allergy existingAllergy = getAllergyById(id);

        existingAllergy.setAllergen(allergy.getAllergen());
        existingAllergy.setSeverity(allergy.getSeverity());
        existingAllergy.setDiagnosedDate(allergy.getDiagnosedDate());
        existingAllergy.setSymptoms(allergy.getSymptoms());
        existingAllergy.setNotes(allergy.getNotes());

        return allergyRepository.save(existingAllergy);
    }

    @Override
    public void deleteAllergy(Long id) {
        Allergy allergy = getAllergyById(id);
        allergyRepository.delete(allergy);
    }
}
