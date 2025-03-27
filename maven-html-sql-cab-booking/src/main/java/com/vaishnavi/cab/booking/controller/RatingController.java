package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;

import java.util.List;
import java.util.Optional;

public class RatingController {
    private final RatingService ratingService;

    // Constructor Injection for RatingService
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // Add Rating
    public void addRating(Rating rating) {
        try {
            ratingService.addRating(rating);
            System.out.println(" Rating added successfully!");
        } catch (Exception e) {
            System.err.println(" Error adding rating: " + e.getMessage());
        }
    }

    // Get All Ratings
    public List<Rating> getAllRatings() {
        try {
            return ratingService.getAllRatings();
        } catch (Exception e) {
            System.err.println("Error fetching ratings: " + e.getMessage());// Return empty list if an error occurs
        }
        return null;
    }

    // Get Rating By ID
    public Optional<Rating> getRatingById(int ratingId) {
        try {
            return ratingService.getRatingById(ratingId);
        } catch (Exception e) {
            System.err.println("Error fetching rating: " + e.getMessage());
            return null;
        }
    }

    // Update Rating
    public void updateRating(int ratingId, int newRating, String newReview) {
        try {
            ratingService.updateRating(ratingId, newRating, newReview);
            System.out.println("Rating updated successfully!");
        } catch (Exception e) {
            System.err.println(" Error updating rating: " + e.getMessage());
        }
    }

    // Delete Rating
    public void deleteRating(int ratingId) {
        try {
            ratingService.deleteRating(ratingId);
            System.out.println(" Rating deleted successfully!");
        } catch (Exception e) {
            System.err.println(" Error deleting rating: " + e.getMessage());
        }
    }
}




