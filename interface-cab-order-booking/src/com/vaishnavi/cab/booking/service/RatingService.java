package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import java.util.List;


public interface RatingService {
    void submitRating(Rating rating);
    Rating getRatingById(int ratingId);
    List<Rating> getAllRatings();

    void ratingOperations();
}
