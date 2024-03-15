package com.example.knowurcompany.company.impl;

import com.example.knowurcompany.company.Company;
import com.example.knowurcompany.company.CompanyRepository;
import com.example.knowurcompany.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company findCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Optional<Company> compy= companyRepository.findById(id);

        if(compy.isPresent()){
            Company comp=compy.get();
            comp.setAddress(company.getAddress());
            comp.setFounder(company.getFounder());
            comp.setNoOfEmployees(company.getNoOfEmployees());
            comp.setName(company.getName());
            companyRepository.save(comp);
        }

    }


}
