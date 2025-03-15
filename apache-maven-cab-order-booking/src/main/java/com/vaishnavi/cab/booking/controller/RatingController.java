package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;

import java.util.List;

public class RatingController {
    private RatingService ratingService = new RatingService();

    // Add Rating
    public void addRating(Rating rating) {
        ratingService.addRating(rating);
    }

    // Get All Ratings
    public void getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        ratings.forEach(System.out::println);
    }

    // Find Rating by ID
    public void getRatingById(int ratingId) {
        Rating rating = ratingService.findRatingById(ratingId);
        if (rating != null) {
            System.out.println(rating);
        } else {
            System.out.println("Rating not found.");
        }
    }

    // Delete Rating by ID
    public void deleteRatingById(int ratingId) {
        ratingService.removeRating(ratingId);
    }
}
