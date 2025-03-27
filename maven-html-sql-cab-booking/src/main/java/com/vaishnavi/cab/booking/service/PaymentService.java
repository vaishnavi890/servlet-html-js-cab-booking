package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;
import java.util.List;
import java.util.Optional;

public class PaymentService implements PaymentServiceInterface {
    private PaymentRepository paymentRepository = new PaymentRepository();

    public PaymentService(PaymentRepository paymentRepository) {
    }

    @Override
    public void makePayment(Payment payment) {
        paymentRepository.addPayment(payment);
    }

    @Override
    public void processPayment(Payment payment) {

    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    @Override
    public Optional<Payment> getPaymentById(int paymentId) {
        return Optional.ofNullable(paymentRepository.getPaymentById(paymentId));
    }

    @Override
    public void updatePaymentStatus(int paymentId, String status) {
        paymentRepository.updatePaymentStatus(paymentId, status);
    }

    @Override
    public void deletePayment(int paymentId) {
        paymentRepository.deletePayment(paymentId);
    }

    @Override
    public void addPayment(Payment payment) {

    }
}


