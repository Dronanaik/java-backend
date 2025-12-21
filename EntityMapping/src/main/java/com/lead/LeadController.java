package com.lead;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService service;

    public LeadController(LeadService service) {
        this.service = service;
    }

    @PostMapping
    public Lead create(@RequestBody Lead lead) {
        return service.createLead(lead);
    }

    @GetMapping("/{id}")
    public Lead get(@PathVariable Long id) {
        return service.getLead(id);
    }

    @GetMapping
    public List<Lead> getAll() {
        return service.getAllLeads();
    }

    @PutMapping("/{id}")
    public Lead update(@PathVariable Long id, @RequestBody Lead lead) {
        return service.updateLead(id, lead);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteLead(id);
        return "Lead deleted successfully!";
    }
}
