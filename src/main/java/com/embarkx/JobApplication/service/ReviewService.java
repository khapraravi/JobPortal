package com.embarkx.JobApplication.service;

import com.embarkx.JobApplication.Entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    void createReview(Review review);
}
