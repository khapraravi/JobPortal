package com.embarkx.JobApplication.service;

import com.embarkx.JobApplication.Entity.Job;
import com.embarkx.JobApplication.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService{
    @Autowired
    private JobRepository jobRepository;


    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    public Job getJobById(int id){

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> deleteJob(int id) {
        try{
            jobRepository.deleteById(id);
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);

    }
    public void updateJob(Job job){
        jobRepository.save(job);
    }
}
