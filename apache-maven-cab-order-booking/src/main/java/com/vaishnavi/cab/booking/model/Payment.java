package com.vaishnavi.cab.booking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Payment {
    private int paymentId;
    private int rideId;
    private int userId;
    private double amount;
    private String paymentMethod;
    private String status;

    public Payment(int paymentId, int rideId, int userId, double amount, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getPaymentId() {
        return 0;
    }
}
