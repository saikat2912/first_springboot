package com.example.knowurcompany.company;

import java.util.List;

public interface CompanyService {

    public List<Company> findAll();

    void addCompany(Company company);

    Company findCompany(Long id);

    void deleteCompany(Long id);

    void updateCompany(Long id, Company company);
}
