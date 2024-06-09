package com.embarkx.JobApplication.service;

import com.embarkx.JobApplication.Entity.Company;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompanyService {
     List<Company> getAllCompanies();
     Company getCompanyById(Long id);

     void updateCompany(Company company);
     void deleteCompany(Long id);
     void createCompany(Company company);

}
