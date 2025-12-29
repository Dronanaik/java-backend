package com.prescription.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for DrugInteraction operations
 * Implements Drug Interaction Check feature
 */
@Service
public class DrugInteractionServiceImpl implements DrugInteractionService {

    @Autowired
    private DrugInteractionRepository interactionRepository;

    @Override
    public List<DrugInteraction> getAllInteractions() {
        return interactionRepository.findAll();
    }

    @Override
    public DrugInteraction getInteractionById(Long id) {
        return interactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drug interaction not found with id: " + id));
    }

    @Override
    public List<DrugInteraction> getInteractionsBySeverity(DrugInteraction.InteractionSeverity severity) {
        return interactionRepository.findBySeverityLevel(severity);
    }

    @Override
    public List<DrugInteraction> findInteractionsBetweenDrugs(Long drugId1, Long drugId2) {
        return interactionRepository.findInteractionsBetweenDrugs(drugId1, drugId2);
    }

    @Override
    public List<DrugInteraction> findInteractionsByDrugId(Long drugId) {
        return interactionRepository.findInteractionsByDrugId(drugId);
    }

    @Override
    public DrugInteraction createInteraction(DrugInteraction interaction) {
        return interactionRepository.save(interaction);
    }

    @Override
    public DrugInteraction updateInteraction(Long id, DrugInteraction interaction) {
        DrugInteraction existingInteraction = getInteractionById(id);

        existingInteraction.setDrug1(interaction.getDrug1());
        existingInteraction.setDrug2(interaction.getDrug2());
        existingInteraction.setSeverityLevel(interaction.getSeverityLevel());
        existingInteraction.setDescription(interaction.getDescription());
        existingInteraction.setRecommendation(interaction.getRecommendation());
        existingInteraction.setClinicalEffects(interaction.getClinicalEffects());

        return interactionRepository.save(existingInteraction);
    }

    @Override
    public void deleteInteraction(Long id) {
        DrugInteraction interaction = getInteractionById(id);
        interactionRepository.delete(interaction);
    }
}
