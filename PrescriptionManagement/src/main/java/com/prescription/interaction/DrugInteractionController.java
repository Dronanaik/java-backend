package com.prescription.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for DrugInteraction operations
 */
@RestController
@RequestMapping("/api/interactions")
@CrossOrigin(origins = "*")
public class DrugInteractionController {

    @Autowired
    private DrugInteractionService interactionService;

    @GetMapping
    public ResponseEntity<List<DrugInteraction>> getAllInteractions() {
        return ResponseEntity.ok(interactionService.getAllInteractions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugInteraction> getInteractionById(@PathVariable Long id) {
        return ResponseEntity.ok(interactionService.getInteractionById(id));
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<DrugInteraction>> getInteractionsBySeverity(
            @PathVariable DrugInteraction.InteractionSeverity severity) {
        return ResponseEntity.ok(interactionService.getInteractionsBySeverity(severity));
    }

    @GetMapping("/between")
    public ResponseEntity<List<DrugInteraction>> findInteractionsBetweenDrugs(
            @RequestParam Long drugId1,
            @RequestParam Long drugId2) {
        return ResponseEntity.ok(interactionService.findInteractionsBetweenDrugs(drugId1, drugId2));
    }

    @GetMapping("/drug/{drugId}")
    public ResponseEntity<List<DrugInteraction>> findInteractionsByDrug(@PathVariable Long drugId) {
        return ResponseEntity.ok(interactionService.findInteractionsByDrugId(drugId));
    }

    @PostMapping
    public ResponseEntity<DrugInteraction> createInteraction(@RequestBody DrugInteraction interaction) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(interactionService.createInteraction(interaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DrugInteraction> updateInteraction(
            @PathVariable Long id,
            @RequestBody DrugInteraction interaction) {
        return ResponseEntity.ok(interactionService.updateInteraction(id, interaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
        return ResponseEntity.noContent().build();
    }
}
