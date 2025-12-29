package com.prescription.drug;

import java.util.List;

/**
 * Service interface for Drug operations
 */
public interface DrugService {

    List<Drug> getAllDrugs();

    Drug getDrugById(Long id);

    Drug getDrugByName(String name);

    List<Drug> getDrugsByCategory(String category);

    List<Drug> searchDrugs(String searchTerm);

    List<Drug> getDrugsByManufacturer(String manufacturer);

    Drug createDrug(Drug drug);

    Drug updateDrug(Long id, Drug drug);

    void deleteDrug(Long id);
}
