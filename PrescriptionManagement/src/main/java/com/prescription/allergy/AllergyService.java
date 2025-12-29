package com.prescription.allergy;

import java.util.List;

/**
 * Service interface for Allergy operations
 */
public interface AllergyService {

    List<Allergy> getAllAllergies();

    Allergy getAllergyById(Long id);

    List<Allergy> getAllergiesByPatientId(Long patientId);

    List<Allergy> getAllergiesBySeverity(Allergy.SeverityLevel severity);

    boolean checkAllergyConflict(Long patientId, String drugName);

    Allergy createAllergy(Allergy allergy);

    Allergy updateAllergy(Long id, Allergy allergy);

    void deleteAllergy(Long id);
}
