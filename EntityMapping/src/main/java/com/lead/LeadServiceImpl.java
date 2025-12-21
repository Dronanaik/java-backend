package com.lead;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {

    private final LeadRepository repository;

    public LeadServiceImpl(LeadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lead createLead(Lead lead) {
        return repository.save(lead);
    }

    @Override
    public Lead getLead(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
    }

    @Override
    public List<Lead> getAllLeads() {
        return repository.findAll();
    }

    @Override
    public Lead updateLead(Long id, Lead updated) {
        Lead existing = getLead(id);

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setStatus(updated.getStatus());
        existing.setCompany(updated.getCompany());

        return repository.save(existing);
    }

    @Override
    public void deleteLead(Long id) {
        repository.deleteById(id);
    }
}
