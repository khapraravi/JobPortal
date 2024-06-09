package com.embarkx.JobApplication.controller;

import com.embarkx.JobApplication.Entity.Company;
import com.embarkx.JobApplication.Entity.Job;
import com.embarkx.JobApplication.service.CompanyService;
import com.embarkx.JobApplication.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobservice;
    private CompanyService companyService;

    public JobController(JobService jobservice,CompanyService companyService) {
        this.jobservice = jobservice;
        this.companyService = companyService;
    }

    @GetMapping("/")
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    private ResponseEntity<List<Job>> findAllJobs(){
        return new ResponseEntity<>(jobservice.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Job> getJobById(@PathVariable int id){
        Job job = jobservice.getJobById(id);
        if(job == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job,HttpStatus.OK);
    }

    @PutMapping("/update")
    private ResponseEntity<String> updateJob(@RequestBody Job job){
        Job job1 = jobservice.getJobById(job.getId());
        if(job1 == null){
            return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
        }else {
            job1.setName(job.getName());
            job1.setDescription(job.getDescription());
            job1.setMinSalary(job.getMinSalary());
            job1.setMaxSalary(job.getMaxSalary());
            job1.setLocation(job.getLocation());

            jobservice.updateJob(job1);
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteJob(@PathVariable int id){
        Job job = jobservice.getJobById(id);
        if(job == null){
            return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
        }
        jobservice.deleteJob(id);
        return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
    }


    @PostMapping("/job")
    private ResponseEntity<String> addJob(@RequestBody Job job){
        Company comp = job.getCompany();
        if(comp == null){
            return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
        }else{
            jobservice.createJob(job);
            return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
        }

    }
}
