package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.impl.PaymentImpl;
import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;

import java.util.*;
import java.util.stream.Collectors;

public class PaymentService implements PaymentImpl {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void addPayment(Payment payment) {
        try {
            paymentRepository.save(payment);
            System.out.println("Payment added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding payment: " + e.getMessage());
        }
    }

    @Override
    public Optional<Payment> getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void updatePayment(Payment payment) {
        try {
            paymentRepository.update(payment);
            System.out.println("Payment updated successfully!");
        } catch (Exception e) {
            System.err.println("Error updating payment: " + e.getMessage());
        }
    }

    @Override
    public void deletePayment(int paymentId) {
        try {
            paymentRepository.delete(paymentId);
            System.out.println("Payment deleted successfully!");
        } catch (Exception e) {
            System.err.println("Error deleting payment: " + e.getMessage());
        }
    }
}
