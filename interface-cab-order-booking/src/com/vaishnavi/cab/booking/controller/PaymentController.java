package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;
import com.vaishnavi.cab.booking.exception.PaymentException;
import java.util.List;

public class PaymentController {
    private PaymentService paymentService = null;

    // Constructor injection
    public PaymentController() {
        this.paymentService = paymentService;
    }

    public void processPayment(Payment payment) {
        try {
            paymentService.processPayment(payment);
            System.out.println("Payment processed successfully.");
        } catch (PaymentException e) {
            System.out.println("Error processing payment: " + e.getMessage());
        }
    }

    public void displayPayments() throws PaymentException {
        List<Payment> payments = paymentService.getAllPayments();
        payments.forEach(payment -> System.out.println(payment.toString()));
    }
    public void startPaymentOperations() {
        try {
            paymentService.paymentOperations();
        } catch (Exception e) {
            System.out.println("Unexpected error in payment operations: " + e.getMessage());
        }
    }

    public void processPayment(int paymentId, int pRideId, int pUserId, double amount, String paymentMethod, String success) {
    }
}
