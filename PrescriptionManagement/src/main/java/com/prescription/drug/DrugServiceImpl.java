package com.prescription.drug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Drug operations
 */
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    @Override
    public Drug getDrugById(Long id) {
        return drugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drug not found with id: " + id));
    }

    @Override
    public Drug getDrugByName(String name) {
        return drugRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Drug not found with name: " + name));
    }

    @Override
    public List<Drug> getDrugsByCategory(String category) {
        return drugRepository.findByCategory(category);
    }

    @Override
    public List<Drug> searchDrugs(String searchTerm) {
        return drugRepository.findByNameContainingIgnoreCaseOrGenericNameContainingIgnoreCase(
                searchTerm, searchTerm);
    }

    @Override
    public List<Drug> getDrugsByManufacturer(String manufacturer) {
        return drugRepository.findByManufacturer(manufacturer);
    }

    @Override
    public Drug createDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public Drug updateDrug(Long id, Drug drug) {
        Drug existingDrug = getDrugById(id);

        existingDrug.setName(drug.getName());
        existingDrug.setGenericName(drug.getGenericName());
        existingDrug.setManufacturer(drug.getManufacturer());
        existingDrug.setDosageForm(drug.getDosageForm());
        existingDrug.setStrength(drug.getStrength());
        existingDrug.setCategory(drug.getCategory());
        existingDrug.setDescription(drug.getDescription());
        existingDrug.setSideEffects(drug.getSideEffects());
        existingDrug.setContraindications(drug.getContraindications());

        return drugRepository.save(existingDrug);
    }

    @Override
    public void deleteDrug(Long id) {
        Drug drug = getDrugById(id);
        drugRepository.delete(drug);
    }
}
