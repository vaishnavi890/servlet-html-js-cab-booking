package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Rating {
    private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private int rating;
    private String review;

    // Constructor
    public Rating(int ratingId, int rideId, int userId, int driverId, int rating, String review) {
        this.ratingId = ratingId;
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.rating = rating;
        this.review = review;
    }

    public int getRideId() {
        return 0;
    }

    public int getUserId() {
        return 0;
    }

    public int getDriverId() {
        return 0;
    }

    public int getRating() {
        return 0;
    }

    public String getReview() {
        return "";
    }

    public void setRatingId(int anInt) {
    }

    public Integer getRatingId() {
        return 0;
    }

    public void setRating(int newRating) {
    }

    public void setReview(String newReview) {
    }
}
