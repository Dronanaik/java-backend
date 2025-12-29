package com.prescription.drug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Drug operations
 */
@RestController
@RequestMapping("/api/drugs")
@CrossOrigin(origins = "*")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @GetMapping
    public ResponseEntity<List<Drug>> getAllDrugs() {
        return ResponseEntity.ok(drugService.getAllDrugs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drug> getDrugById(@PathVariable Long id) {
        return ResponseEntity.ok(drugService.getDrugById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Drug> getDrugByName(@PathVariable String name) {
        return ResponseEntity.ok(drugService.getDrugByName(name));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Drug>> getDrugsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(drugService.getDrugsByCategory(category));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Drug>> searchDrugs(@RequestParam String term) {
        return ResponseEntity.ok(drugService.searchDrugs(term));
    }

    @GetMapping("/manufacturer/{manufacturer}")
    public ResponseEntity<List<Drug>> getDrugsByManufacturer(@PathVariable String manufacturer) {
        return ResponseEntity.ok(drugService.getDrugsByManufacturer(manufacturer));
    }

    @PostMapping
    public ResponseEntity<Drug> createDrug(@RequestBody Drug drug) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(drugService.createDrug(drug));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drug> updateDrug(@PathVariable Long id, @RequestBody Drug drug) {
        return ResponseEntity.ok(drugService.updateDrug(id, drug));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrug(@PathVariable Long id) {
        drugService.deleteDrug(id);
        return ResponseEntity.noContent().build();
    }
}
