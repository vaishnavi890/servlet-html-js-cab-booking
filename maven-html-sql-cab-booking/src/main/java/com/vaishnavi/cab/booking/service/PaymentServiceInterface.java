package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentServiceInterface {
    void makePayment(Payment payment);

    void processPayment(Payment payment);
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(int paymentId);
    void updatePaymentStatus(int paymentId, String status);
    void deletePayment(int paymentId);

    void addPayment(Payment payment);
}



