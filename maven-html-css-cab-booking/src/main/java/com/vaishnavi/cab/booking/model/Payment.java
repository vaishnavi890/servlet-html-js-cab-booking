package com.vaishnavi.cab.booking.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Data

public class Payment {
    private int paymentId;
    private int rideId;
    private int userId;
    private double amount;
    private String paymentMethod;
    private String status;

    public Payment(int paymentId, int userId, double amount, LocalDate paymentDate, String paymentMethod) {
    }

    public Payment() {

    }


    public int getPaymentId() {
        return paymentId;
    }

    public int getRideId() {
        return rideId;
    }

    public int getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentDate() {
        return "PaymentDate";
    }
}
