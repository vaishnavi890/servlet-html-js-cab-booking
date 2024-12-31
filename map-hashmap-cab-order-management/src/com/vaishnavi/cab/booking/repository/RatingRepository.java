package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import java.util.HashMap;
import java.util.Map;

public class RatingRepository {
    private Map<String, Rating> ratingMap = new HashMap<>();

    public void addRating(Rating rating) {
        ratingMap.put(rating.getRatingId(), rating);
    }

    public Rating getRating(String ratingId) {
        return ratingMap.get(ratingId);
    }

    public void removeRating(String ratingId) {
        ratingMap.remove(ratingId);
    }

    public int getRatingCount() {
        return ratingMap.size();
    }

    public void displayAllRatings() {
        ratingMap.entrySet().forEach(entry ->
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
    }
}
