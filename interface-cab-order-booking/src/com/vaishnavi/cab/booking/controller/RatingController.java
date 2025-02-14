package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;
import com.vaishnavi.cab.booking.exception.RatingException;
import java.util.List;

public class RatingController {
    private RatingService ratingService;

    // Constructor injection
    public RatingController() {
        this.ratingService = ratingService;
    }

    public void submitRating(Rating rating) {
        ratingService.submitRating(rating);
        System.out.println("Rating submitted successfully.");
    }

    public void displayRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        ratings.forEach(rating -> System.out.println(rating.toString()));
    }

    public void startRatingOperations() {
        try {
            ratingService.ratingOperations();
        } catch (Exception e) {
            System.out.println("Unexpected error in rating operations: " + e.getMessage());
        }
    }

    public void submitRating(int ratingId, int rateRideId, int rateUserId, int rateDriverId, int rating, String review) {

    }
}
