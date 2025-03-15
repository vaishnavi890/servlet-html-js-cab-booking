package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RatingRepository {
    private List<Rating> ratings = new ArrayList<>();

    // Save a new rating
    public void saveRating(Rating rating) {
        ratings.add(rating);
        System.out.println("Rating saved successfully!");
    }

    // Get all ratings
    public List<Rating> findAllRatings() {
        return new ArrayList<>(ratings);
    }

    // Find rating by ID
    public Optional<Rating> findRatingById(int ratingId) {
        return ratings.stream()
                .filter(rating -> rating.getRatingId() == ratingId)
                .findFirst();
    }

    // Remove rating by ID
    public boolean deleteRatingById(int ratingId) {
        return ratings.removeIf(rating -> rating.getRatingId() == ratingId);
    }
}
