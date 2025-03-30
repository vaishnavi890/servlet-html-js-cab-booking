package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;
import java.util.List;

public class RatingService {

    private final RatingRepository ratingRepository = new RatingRepository();

    public boolean rateDriver(Rating rating) {
        if (rating.getRideId() <= 0 || rating.getUserId() <= 0 || rating.getDriverId() <= 0) {
            throw new IllegalArgumentException("Invalid ride, user, or driver ID!");
        }
        if (rating.getRating() < 1 || rating.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5!");
        }
        return ratingRepository.addRating(rating);
    }

    public List<Rating> getDriverRatings(int driverId) {
        return ratingRepository.getRatingsByDriverId(driverId);
    }

    public boolean submitRating(Rating rating) {
        return false;
    }

    public List<Rating> getRatingsByDriver(int driverId) {
        return List.of();
    }
}


