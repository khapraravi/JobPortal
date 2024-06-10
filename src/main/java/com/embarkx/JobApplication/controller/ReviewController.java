package com.embarkx.JobApplication.controller;

import com.embarkx.JobApplication.Entity.Company;
import com.embarkx.JobApplication.Entity.Job;
import com.embarkx.JobApplication.Entity.Review;
import com.embarkx.JobApplication.service.CompanyService;
import com.embarkx.JobApplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("companies/{companyid}")
public class ReviewController {
    private ReviewService reviewService;
    private CompanyService companyService;

    public ReviewController(ReviewService reviewService,CompanyService companyService) {
        this.reviewService = reviewService;
        this.companyService= companyService;
    }

    @GetMapping("/reviews")
    public List<Review> getReviewsByCompanyId(@PathVariable Long companyid){
        Company comp = companyService.getCompanyById(companyid);
        if(comp == null){
            System.out.println("Company not found");
            return new ArrayList<Review>();
        }else{
            return reviewService.getAllReviews(companyid);
        }
    }

    @PostMapping("/reviews")
    private ResponseEntity<String> addReview(@PathVariable Long companyid,@RequestBody Review review){
        Company comp = companyService.getCompanyById(companyid);
        if(comp == null){
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }else{
            review.setCompany(comp);
            reviewService.createReview(review);
            return new ResponseEntity<>("Review added successfully",HttpStatus.CREATED);
        }

    }
}
