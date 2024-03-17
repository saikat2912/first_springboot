package com.example.knowurcompany.review.impl;

import com.example.knowurcompany.company.Company;
import com.example.knowurcompany.company.CompanyRepository;
import com.example.knowurcompany.company.CompanyService;
import com.example.knowurcompany.review.ReviewRepository;
import com.example.knowurcompany.review.ReviewService;
import com.example.knowurcompany.review.Reviews;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {


    private ReviewRepository reviewRepository;
    private CompanyService companyService;


    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }

    @Override
    public List<Reviews> findAll(Long companyId) {
        List<Reviews> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void createReview(Long companyId,Reviews review) {

        Company company= companyService.findCompany(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
        }



    }

    @Override
    public Reviews getReviewById(Long companyid,Long id) {

        List<Reviews> reviews = reviewRepository.findByCompanyId(companyid);
        return reviews.stream().
                filter(review ->review.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateReviewById(Long companyId,Long id,Reviews review) {
        List<Reviews> reviews = reviewRepository.findByCompanyId(companyid);
        Optional<Reviews> rev= reviews.stream().
                filter(review ->review.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteReview(Long id) {

    }
}
