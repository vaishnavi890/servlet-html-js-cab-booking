package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private Map<String, Payment> paymentMap = new HashMap<>();

    public void addPayment(Payment payment) {
        paymentMap.put(payment.getPaymentId(), payment);
    }

    public Payment getPayment(String paymentId) {
        return paymentMap.get(paymentId);
    }

    public void removePayment(String paymentId) {
        paymentMap.remove(paymentId);
    }

    public boolean containsPayment(String paymentId) {
        return paymentMap.containsKey(paymentId);
    }

    public void displayAllPayments() {
        paymentMap.entrySet().forEach(entry ->
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
    }
}
