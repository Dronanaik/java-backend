package com.company;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);

    Company getCompany(Long id);

    List<Company> getAllCompanies();

    Company updateCompany(Long id, Company updated);

    void deleteCompany(Long id);
}
