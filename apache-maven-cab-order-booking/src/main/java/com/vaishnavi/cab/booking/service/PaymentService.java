package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentService {
    private List<Payment> payments = new ArrayList<>();

    // Add Payment
    public void addPayment(Payment payment) {
        payments.add(payment);
        System.out.println("Payment added successfully!");
    }

    // Get All Payments
    public List<Payment> getAllPayments() {
        return payments;
    }

    // Find Payment by ID
    public Payment findPaymentById(int paymentId) {
        Optional<Payment> payment = payments.stream()
                .filter(p -> p.getPaymentId() == paymentId)
                .findFirst();
        if (payment.isPresent()) {
            return payment.get();
        } else {
            System.out.println("Payment not found.");
            return null;
        }
    }

    // Remove Payment by ID
    public void removePayment(int paymentId) {
        if (payments.removeIf(p -> p.getPaymentId() == paymentId)) {
            System.out.println("Payment removed successfully!");
        } else {
            System.out.println("Payment not found.");
        }
    }
}
