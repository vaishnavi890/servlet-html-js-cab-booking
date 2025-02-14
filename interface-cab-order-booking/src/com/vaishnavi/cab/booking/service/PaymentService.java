package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.exception.PaymentException;
import java.util.List;

public interface PaymentService {
    void processPayment(Payment payment) throws PaymentException;
    Payment getPaymentById(int paymentId) throws PaymentException;
    List<Payment> getAllPayments() throws PaymentException;

    void paymentOperations();
}
