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
    public boolean updateReviewById(Long companyId,Long id,Reviews review) {
        if(companyService.findCompany(id)!=null){
            review.setCompany(companyService.findCompany(companyId));
            review.setId(id);
            reviewRepository.save(review);
            return true;
        }
        else{
            return false;
        }


    }

    @Override
    public boolean deleteReview(Long companyId,Long reviewId) {
        List<Reviews> reviews = reviewRepository.findByCompanyId(companyId);
        Optional<Reviews> rev= Optional.ofNullable(reviews.stream().
                filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null));

        if(rev.isPresent()){
            Reviews review1=rev.get();
            System.out.println("Review 1 is "+review1);
            reviewRepository.delete(review1);

            return true;
        }

        return false;

    }
}
