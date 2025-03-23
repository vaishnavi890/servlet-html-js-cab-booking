package com.vaishnavi.cab.booking.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
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
}
