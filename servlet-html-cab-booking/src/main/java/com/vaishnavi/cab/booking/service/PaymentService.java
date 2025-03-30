package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;
import java.util.List;

public class PaymentService {

    private final PaymentRepository paymentRepository = new PaymentRepository();

    public boolean processPayment(Payment payment) {
        if (payment.getRideId() <= 0 || payment.getUserId() <= 0) {
            throw new IllegalArgumentException("Invalid ride or user ID!");
        }
        if (payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero!");
        }
        return paymentRepository.addPayment(payment);
    }

    public List<Payment> getPaymentHistory(int userId) {
        return paymentRepository.getPaymentsByUserId(userId);
    }

    public boolean updatePaymentStatus(int paymentId, String status) {
        return paymentRepository.updatePaymentStatus(paymentId, status);
    }

    public boolean makePayment(Payment payment) {
        return false;
    }

    public List<Payment> getPaymentsByUser(int userId) {
        return List.of();
    }
}



