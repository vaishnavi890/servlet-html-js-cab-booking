package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Data

public class Rating {private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private int rating;
    private String review;

    public Rating(int ratingId, int rideId, int userId, int driverId, int rating, String feedback) {
    }
}
