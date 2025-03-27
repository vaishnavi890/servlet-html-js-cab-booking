package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;

import java.util.List;
import java.util.Optional;

public class PaymentController {
    private final PaymentService paymentService;

    // Constructor Injection for PaymentService
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Add Payment with try-catch
    public void addPayment(Payment payment) {
        try {
            paymentService.addPayment(payment);
            System.out.println(" Payment added successfully!");
        } catch (Exception e) {
            System.err.println(" Error adding payment: " + e.getMessage());
        }
    }

    // Get All Payments
    public List<Payment> getAllPayments() {
        try {
            return paymentService.getAllPayments();
        } catch (Exception e) {
            System.err.println("Error retrieving payments: " + e.getMessage());
        }
        return null;
    }

    // Get Payment By ID
    public Optional<Payment> getPaymentById(int paymentId) {
        try {
            return paymentService.getPaymentById(paymentId);
        } catch (Exception e) {
            System.err.println(" Error retrieving payment: " + e.getMessage());
        }
        return null;
    }

    // Update Payment Status with try-catch
    public void updatePaymentStatus(int paymentId, String status) {
        try {
            paymentService.updatePaymentStatus(paymentId, status);
            System.out.println(" Payment status updated successfully!");
        } catch (Exception e) {
            System.err.println(" Error updating payment status: " + e.getMessage());
        }
    }

    // Delete Payment with try-catch
    public void deletePayment(int paymentId) {
        try {
            paymentService.deletePayment(paymentId);
            System.out.println(" Payment deleted successfully!");
        } catch (Exception e) {
            System.err.println(" Error deleting payment: " + e.getMessage());
        }
    }
}



