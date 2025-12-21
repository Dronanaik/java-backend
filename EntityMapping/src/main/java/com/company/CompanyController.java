package com.company;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return service.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company get(@PathVariable Long id) {
        return service.getCompany(id);
    }

    @GetMapping
    public List<Company> getAll() {
        return service.getAllCompanies();
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable Long id, @RequestBody Company company) {
        return service.updateCompany(id, company);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteCompany(id);
        return "Company deleted successfully!";
    }
}
