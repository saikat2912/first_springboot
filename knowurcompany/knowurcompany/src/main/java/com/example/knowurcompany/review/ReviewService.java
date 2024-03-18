package com.example.knowurcompany.review;

import java.util.List;

public interface ReviewService {

    List<Reviews> findAll(Long companyId);

    void createReview(Long comapanyId,Reviews review);

    Reviews getReviewById(Long companyId,Long id);

    boolean updateReviewById(Long companyId,Long id,Reviews review);

    boolean deleteReview(Long companyId,Long reviewId);
}
