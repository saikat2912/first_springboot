package com.example.knowurcompany.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reveiwService;

    public ReviewController(ReviewService reveiwService) {
        this.reveiwService = reveiwService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reveiwService.findAll(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> postReview(@PathVariable Long companyId, @RequestBody Reviews review){

            boolean val=reveiwService.createReview(companyId,review);

            if(val){
                return new ResponseEntity<>("Review Posted Successfully",HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Error in review Posting try again later",HttpStatus.BAD_REQUEST);
            }

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId){
         return new ResponseEntity<>(reveiwService.getReviewById(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Reviews review){
        boolean val = reveiwService.updateReviewById(companyId,reviewId,review);
        if(val==true){
            return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review updation failed",HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean val= reveiwService.deleteReview(companyId,reviewId);
        if(val){
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review deletion failed",HttpStatus.NOT_FOUND);

    }



}
