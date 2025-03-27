package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Data

public class Rating {
    private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private double rating;
    private String feedback;

    public Rating(int ratingId, int rideId, int userId, int driverId, int rating, String feedback) {
    }

    public Rating() {

    }


    public int getRatingId() {
        return ratingId;
    }

    public int getRideId() {
        return rideId;
    }

    public int getUserId() {
        return userId;
    }

    public int getDriverId() {
        return driverId;
    }

    public double getRating() {
        return rating;
    }

    public String getFeedback() {
        return "";
    }
}
