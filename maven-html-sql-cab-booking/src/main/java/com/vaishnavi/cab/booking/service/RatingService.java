package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;
import java.util.List;
import java.util.Optional;

public class RatingService implements RatingServiceInterface {
    private RatingRepository ratingRepository = new RatingRepository();

    public RatingService(RatingRepository ratingRepository) {
    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.addRating(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.getAllRatings();
    }

    @Override
    public Optional<Rating> getRatingById(int ratingId) {
        return Optional.ofNullable(ratingRepository.getRatingById(ratingId));
    }

    @Override
    public void updateRating(int ratingId, int ratingValue, String review) {
        ratingRepository.updateRating(ratingId, ratingValue, review);
    }

    @Override
    public void deleteRating(int ratingId) {
        ratingRepository.deleteRating(ratingId);
    }
}

