package com.embarkx.JobApplication.Repository;

import com.embarkx.JobApplication.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
