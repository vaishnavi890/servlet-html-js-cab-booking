package com.vaishnavi.servlet.cab.booking.service;

import com.vaishnavi.servlet.cab.booking.model.Payment;
import com.vaishnavi.servlet.cab.booking.repository.PaymentRepository;

import java.util.List;

public class PaymentService {
    private final PaymentRepository repo = new PaymentRepository();

    public void makePayment(Payment payment) {
        repo.insertPayment(payment);
    }

    public List<Payment> getAllPayments() {
        return repo.getAllPayments();
    }
}


