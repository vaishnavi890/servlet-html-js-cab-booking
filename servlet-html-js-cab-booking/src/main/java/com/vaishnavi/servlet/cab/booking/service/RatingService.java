package com.vaishnavi.servlet.cab.booking.service;

import com.vaishnavi.servlet.cab.booking.model.Rating;
import com.vaishnavi.servlet.cab.booking.repository.RatingRepository;

import java.util.List;

public class RatingService {
    private final RatingRepository repo = new RatingRepository();

    public void rateDriver(Rating rating) {
        repo.insertRating(rating);
    }

    public List<Rating> getAllRatings() {
        return repo.getAllRatings();
    }
}
