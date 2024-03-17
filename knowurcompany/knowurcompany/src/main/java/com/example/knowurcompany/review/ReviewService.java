package com.example.knowurcompany.review;

import java.util.List;

public interface ReviewService {

    List<Reviews> findAll(Long companyId);

    void createReview(Long comapanyId,Reviews review);

    Reviews getReviewById(Long companyId,Long id);

    void updateReviewById(Long companyId,Long id,Reviews review);

    void deleteReview(Long id);
}
