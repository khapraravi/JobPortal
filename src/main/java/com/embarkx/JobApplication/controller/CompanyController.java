package com.embarkx.JobApplication.controller;

import com.embarkx.JobApplication.Entity.Company;
import com.embarkx.JobApplication.Entity.Job;
import com.embarkx.JobApplication.service.CompanyService;
import com.embarkx.JobApplication.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(company,HttpStatus.OK);
    }

    @PutMapping("/update")
    private ResponseEntity<String> updateCompany(@RequestBody Company company){
        Company company1 = companyService.getCompanyById(company.getId());
        if(company1 == null){
            return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
        }else {
            company1.setName(company.getName());
            company1.setDescription(company.getDescription());

            companyService.updateCompany(company1);
            return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteCompany(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company == null){
            return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
        }
        companyService.deleteCompany(id);
        return new ResponseEntity<>("company deleted successfully",HttpStatus.OK);
    }


    @PostMapping("/company")
    private ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully",HttpStatus.CREATED);
    }
}
