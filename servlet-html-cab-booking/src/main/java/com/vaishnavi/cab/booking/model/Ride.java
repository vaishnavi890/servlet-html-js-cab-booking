package com.vaishnavi.cab.booking.model;

public class Ride {
    private int rideId;
    private int userId;
    private int driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private double fare;
    private String status;

    // Constructors
    public Ride() {}

    public Ride(int rideId, int userId, int driverId, String pickupLocation, String dropoffLocation, double fare, String status) {
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.fare = fare;
        this.status = status;
    }

    public Ride(int rideId, int userId, java.lang.String pickupLocation, java.lang.String dropoffLocation, double fare) {
    }

    // Getters and Setters
    public int getRideId() { return rideId; }
    public void setRideId(int rideId) { this.rideId = rideId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

    public String getDropoffLocation() { return dropoffLocation; }
    public void setDropoffLocation(String dropoffLocation) { this.dropoffLocation = dropoffLocation; }

    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // toString() method
    @Override
    public String toString() {
        return "Ride [ID=" + rideId + ", UserID=" + userId + ", DriverID=" + driverId + ", Pickup=" + pickupLocation + ", Dropoff=" + dropoffLocation + ", Fare=" + fare + ", Status=" + status + "]";
    }
}

