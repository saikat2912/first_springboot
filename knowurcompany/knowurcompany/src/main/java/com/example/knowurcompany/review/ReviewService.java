package com.example.knowurcompany.review;

import java.util.List;

public interface ReviewService {

    List<Reviews> findAll();

    void createReview(Reviews review);

    Reviews getReviewById(Long id);

    void updateReviewById(Long id);

    void deleteReview(Long id);
}
