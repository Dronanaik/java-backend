package com.transaction.standing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Standing Instruction operations
 */
@RestController
@RequestMapping("/api/standing-instructions")
@CrossOrigin(origins = "*")
public class StandingInstructionController {

    @Autowired
    private StandingInstructionService standingInstructionService;

    @GetMapping
    public ResponseEntity<List<StandingInstruction>> getAllInstructions() {
        return ResponseEntity.ok(standingInstructionService.getAllInstructions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandingInstruction> getInstructionById(@PathVariable Long id) {
        return ResponseEntity.ok(standingInstructionService.getInstructionById(id));
    }

    @PostMapping
    public ResponseEntity<StandingInstruction> createInstruction(@RequestBody StandingInstruction instruction) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(standingInstructionService.createInstruction(instruction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandingInstruction> updateInstruction(
            @PathVariable Long id,
            @RequestBody StandingInstruction instruction) {
        return ResponseEntity.ok(standingInstructionService.updateInstruction(id, instruction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstruction(@PathVariable Long id) {
        standingInstructionService.deleteInstruction(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/execute-due")
    public ResponseEntity<String> executeStandingInstructions() {
        standingInstructionService.executeStandingInstructions();
        return ResponseEntity.ok("Standing instructions executed successfully");
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<StandingInstruction>> getInstructionsByAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(standingInstructionService.getInstructionsByAccount(accountId));
    }
}
