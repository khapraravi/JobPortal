package com.embarkx.JobApplication.Repository;

import com.embarkx.JobApplication.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
}
