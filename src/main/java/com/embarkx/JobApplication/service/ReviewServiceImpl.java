package com.embarkx.JobApplication.service;

import com.embarkx.JobApplication.Entity.Review;
import com.embarkx.JobApplication.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }
}
