package com.embarkx.JobApplication.Repository;

import com.embarkx.JobApplication.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
