package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;


import java.util.List;
import java.util.Optional;

public class RatingController {
    private RatingService ratingService = null;

    public RatingController() {
        this.ratingService = ratingService;
    }

    public void addRating() {
        try {
            Rating rating = new Rating();
            ratingService.saveRating(rating);
            System.out.println("Rating added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding rating: " + e.getMessage());
        }
    }

    public void getRatingById(int ratingId) {
        try {
            Optional<Rating> rating = ratingService.getRatingById(ratingId);
            rating.ifPresentOrElse(
                    r -> System.out.println("Rating found: " + r),
                    () -> System.out.println("Rating not found.")
            );
        } catch (Exception e) {
            System.err.println("Error fetching rating: " + e.getMessage());
        }
    }

    public void getAllRatings() {
        try {
            List<Rating> ratings = ratingService.getAllRatings();
            ratings.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching ratings: " + e.getMessage());
        }
    }

    public void updateRating() {
        try {
            Rating rating = new Rating();
            ratingService.updateRating(rating);
            System.out.println("Rating updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating rating: " + e.getMessage());
        }
    }

    public void deleteRating() {
        try {
            int ratingId = 0;
            ratingService.deleteRating(ratingId);
            System.out.println("Rating deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting rating: " + e.getMessage());
        }
    }
}
