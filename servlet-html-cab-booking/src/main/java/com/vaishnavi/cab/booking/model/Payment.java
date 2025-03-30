package com.vaishnavi.cab.booking.model;

public class Payment {
    private int paymentId;
    private int rideId;
    private int userId;
    private double amount;
    private String paymentMethod;
    private String status;

    // Constructors
    public Payment() {}

    public Payment(int paymentId, int rideId, int userId, double amount, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    // Getters and Setters
    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public int getRideId() { return rideId; }
    public void setRideId(int rideId) { this.rideId = rideId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // toString() method
    @Override
    public String toString() {
        return "Payment [ID=" + paymentId + ", RideID=" + rideId + ", UserID=" + userId + ", Amount=" + amount + ", Method=" + paymentMethod + ", Status=" + status + "]";
    }
}
