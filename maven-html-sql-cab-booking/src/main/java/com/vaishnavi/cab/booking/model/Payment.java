package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Data
@NonNull
@NoArgsConstructor


public class Payment {
    private int paymentId;
    private int rideId;
    private int userId;
    private double amount;
    private String paymentMethod;
    private String status;

    // Constructor
    public Payment(int paymentId, int rideId, int userId, double amount, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getRideId() {
        return 0;
    }

    public int getUserId() {
        return 0;
    }

    public double getAmount() {
        return 0;
    }

    public String getPaymentMethod() {
        return "";
    }

    public String getStatus() {
        return "";
    }

    public void setPaymentId(int anInt) {
    }

    public Integer getPaymentId() {
        return 0;
    }

    public void setStatus(String status) {
    }
}
