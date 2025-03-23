package com.vaishnavi.cab.booking.impl;

import com.vaishnavi.cab.booking.model.Rating;
import java.util.List;
import java.util.Optional;

public interface RatingImpl {
    void addRating(Rating rating);
    Optional<Rating> getRatingById(int ratingId);
    List<Rating> getAllRatings();
    void updateRating(Rating rating);
    void deleteRating(int ratingId);
}
