package com.vaishnavi.cab.booking.impl;

import com.vaishnavi.cab.booking.model.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentImpl {
    void addPayment(Payment payment);
    Optional<Payment> getPaymentById(int paymentId);
    List<Payment> getAllPayments();
    void updatePayment(Payment payment);
    void deletePayment(int paymentId);
}
