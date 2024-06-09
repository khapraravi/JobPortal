package com.embarkx.JobApplication.controller;

import com.embarkx.JobApplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("companies/{companyid}")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(){

    }

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
