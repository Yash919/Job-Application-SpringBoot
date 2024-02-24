package com.embarkx.firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review){

        boolean isReviewSaved=reviewService.addReview(companyId,review);
        if(isReviewSaved) {
            return new ResponseEntity<>("Review Added Successfully for the Company id: " + String.valueOf(companyId), HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not saved Successfully",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){

        Review review=reviewService.getReview(companyId, reviewId);

        if(review!=null){
            return new ResponseEntity<>(review,HttpStatus.OK);
        } else{
            ErrorResponse errorResponse = new ErrorResponse("No reviews found for company ID " + companyId + " review ID " + reviewId + ".");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){

        boolean isReviewUpdated= reviewService.updateReview(companyId,reviewId,review);

        if(isReviewUpdated) {
            return new ResponseEntity<>("Review updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not updated. No review found with ID " + reviewId + " for Company ID " + companyId + ".", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){

        boolean isReviewDeleted=reviewService.deleteReview(companyId,reviewId);

        if(isReviewDeleted) {
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not Deleted. No review found with ID " + reviewId + " for Company ID " + companyId + ".", HttpStatus.NOT_FOUND);
    }
}
