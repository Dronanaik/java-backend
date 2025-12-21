package com.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company createCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public Company getCompany(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
    }

    @Override
    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    @Override
    public Company updateCompany(Long id, Company updated) {
        Company existing = getCompany(id);
        existing.setName(updated.getName());
        existing.setLocation(updated.getLocation());
        return repository.save(existing);
    }

    @Override
    public void deleteCompany(Long id) {
        repository.deleteById(id);
    }
}
