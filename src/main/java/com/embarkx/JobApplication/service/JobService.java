package com.embarkx.JobApplication.service;

import com.embarkx.JobApplication.Entity.Job;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    void updateJob(Job job);
    Job getJobById(int id);
    ResponseEntity<String> deleteJob(int id);
}
