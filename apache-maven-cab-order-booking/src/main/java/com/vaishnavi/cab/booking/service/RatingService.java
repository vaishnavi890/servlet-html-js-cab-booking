package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RatingService {
    private List<Rating> ratings = new ArrayList<>();

    // Add Rating
    public void addRating(Rating rating) {
        ratings.add(rating);
        System.out.println("Rating added successfully!");
    }

    // Get All Ratings
    public List<Rating> getAllRatings() {
        return ratings;
    }

    // Find Rating by ID
    public Rating findRatingById(int ratingId) {
        Optional<Rating> rating = ratings.stream()
                .filter(r -> r.getRatingId() == ratingId)
                .findFirst();
        if (rating.isPresent()) {
            return rating.get();
        } else {
            System.out.println("Rating not found.");
            return null;
        }
    }

    // Remove Rating by ID
    public void removeRating(int ratingId) {
        if (ratings.removeIf(r -> r.getRatingId() == ratingId)) {
            System.out.println("Rating removed successfully!");
        } else {
            System.out.println("Rating not found.");
        }
    }
}
