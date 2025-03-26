package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString

public class Ride {
    private int rideId;
    private int userId;
    private int driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private double fare;
    private String status;

    public Ride(int rideId, int userId, int driverId, String pickupLocation, String dropoffLocation, double fare, String status) {
    }

    public Ride() {

    }


    public int getUserId() {
        return 0;
    }

    public int getDriverId() {
        return 0;
    }

    public int getRideId() {
        return rideId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public double getFare() {
        return fare;
    }

    public String getStatus() {
        return status;
    }
}
