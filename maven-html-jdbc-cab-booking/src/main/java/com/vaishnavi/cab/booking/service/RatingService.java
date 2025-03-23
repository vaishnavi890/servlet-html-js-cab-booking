package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.impl.RatingImpl;
import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;

import java.util.*;
import java.util.stream.Collectors;

public class RatingService implements RatingImpl {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void addRating(Rating rating) {
        try {
            ratingRepository.save(rating);
            System.out.println("Rating added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding rating: " + e.getMessage());
        }
    }

    @Override
    public Optional<Rating> getRatingById(int ratingId) {
        return ratingRepository.findById(ratingId);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void updateRating(Rating rating) {
        try {
            ratingRepository.update(rating);
            System.out.println("Rating updated successfully!");
        } catch (Exception e) {
            System.err.println("Error updating rating: " + e.getMessage());
        }
    }

    @Override
    public void deleteRating(int ratingId) {
        try {
            ratingRepository.delete(ratingId);
            System.out.println("Rating deleted successfully!");
        } catch (Exception e) {
            System.err.println("Error deleting rating: " + e.getMessage());
        }
    }
}
