package com.prescription.interaction;

import java.util.List;

/**
 * Service interface for DrugInteraction operations
 */
public interface DrugInteractionService {

    List<DrugInteraction> getAllInteractions();

    DrugInteraction getInteractionById(Long id);

    List<DrugInteraction> getInteractionsBySeverity(DrugInteraction.InteractionSeverity severity);

    List<DrugInteraction> findInteractionsBetweenDrugs(Long drugId1, Long drugId2);

    List<DrugInteraction> findInteractionsByDrugId(Long drugId);

    DrugInteraction createInteraction(DrugInteraction interaction);

    DrugInteraction updateInteraction(Long id, DrugInteraction interaction);

    void deleteInteraction(Long id);
}
