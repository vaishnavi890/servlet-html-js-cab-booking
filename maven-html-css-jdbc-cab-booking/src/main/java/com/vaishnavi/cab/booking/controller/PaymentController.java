package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;

import java.util.List;
import java.util.Optional;

public class PaymentController {

    private PaymentService paymentService = null;

    public PaymentController() {
        this.paymentService = paymentService;
    }

    public void addPayment() {
        try {
            Payment payment = new Payment();
            paymentService.savePayment(payment);
            System.out.println("Payment added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding payment: " + e.getMessage());
        }
    }

    public void getPaymentById(int paymentId) {
        try {
            Optional<Payment> payment = paymentService.getPaymentById(paymentId);
            payment.ifPresentOrElse(
                    p -> System.out.println("Payment found: " + p),
                    () -> System.out.println("Payment not found.")
            );
        } catch (Exception e) {
            System.err.println("Error fetching payment: " + e.getMessage());
        }
    }

    public void getAllPayments() {
        try {
            List<Payment> payments = paymentService.getAllPayments();
            payments.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching payments: " + e.getMessage());
        }
    }

    public void updatePayment() {
        try {
            Payment payment = new Payment();
            paymentService.updatePayment(payment);
            System.out.println("Payment updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating payment: " + e.getMessage());
        }
    }

    public void deletePayment() {
        try {
            int paymentId = 0;
            paymentService.deletePayment(paymentId);
            System.out.println("Payment deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting payment: " + e.getMessage());
        }
    }
}
