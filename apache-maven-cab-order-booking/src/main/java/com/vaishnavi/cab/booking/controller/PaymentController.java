package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;

import java.util.List;

public class PaymentController {
    private PaymentService paymentService = new PaymentService();

    // Add Payment
    public void addPayment(Payment payment) {
        paymentService.addPayment(payment);
    }

    // Get All Payments
    public void getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        payments.forEach(System.out::println);
    }

    // Find Payment by ID
    public void getPaymentById(int paymentId) {
        Payment payment = paymentService.findPaymentById(paymentId);
        if (payment != null) {
            System.out.println(payment);
        } else {
            System.out.println("Payment not found.");
        }
    }

    // Delete Payment by ID
    public void deletePaymentById(int paymentId) {
        paymentService.removePayment(paymentId);
    }
}
