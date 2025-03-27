package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@ToString@NoArgsConstructor
@RequiredArgsConstructor
@NonNull
@Data

public class Ride {
    private int rideId;
    private int userId;
    private int driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private double fare;
    private String status;

    // Constructor
    public Ride(int rideId, int userId, int driverId, String pickupLocation, String dropoffLocation, double fare, String status) {
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.fare = fare;
        this.status = status;
    }

    public void setStatus(String status) {
    }

    public int getUserId() {
        return 0;
    }

    public int getDriverId() {
        return 0;
    }

    public String getPickupLocation() {
        return "";
    }

    public String getDropoffLocation() {
        return "";
    }

    public double getFare() {
        return 0;
    }

    public String getStatus() {
        return "";
    }

    public void setRideId(int anInt) {
    }

    public Integer getRideId() {
        return 0;
    }
}
