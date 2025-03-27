package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import java.util.List;
import java.util.Optional;

public interface RatingServiceInterface {
    void addRating(Rating rating);
    List<Rating> getAllRatings();
    Optional<Rating> getRatingById(int ratingId);
    void updateRating(int ratingId, int ratingValue, String review);
    void deleteRating(int ratingId);
}




