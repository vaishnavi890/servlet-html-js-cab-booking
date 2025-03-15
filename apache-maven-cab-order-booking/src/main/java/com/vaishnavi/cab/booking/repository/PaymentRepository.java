package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    // Save a new payment
    public void savePayment(Payment payment) {
        payments.add(payment);
        System.out.println("Payment saved successfully!");
    }

    // Get all payments
    public List<Payment> findAllPayments() {
        return new ArrayList<>(payments);
    }

    // Find payment by ID
    public Optional<Payment> findPaymentById(int paymentId) {
        return payments.stream()
                .filter(payment -> payment.getPaymentId() == paymentId)
                .findFirst();
    }

    // Remove payment by ID
    public boolean deletePaymentById(int paymentId) {
        return payments.removeIf(payment -> payment.getPaymentId() == paymentId);
    }
}

