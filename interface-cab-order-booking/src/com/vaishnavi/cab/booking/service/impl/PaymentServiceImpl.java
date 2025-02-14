package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.service.PaymentService;
import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.exception.PaymentException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentServiceImpl implements PaymentService {
    private List<Payment> payments = new ArrayList<>();

    @Override
    public void processPayment(Payment payment) throws PaymentException {
        if (payment == null || payment.getAmount() <= 0) {
            throw new PaymentException("Invalid payment details!");
        }
        payments.add(payment);
        System.out.println("Payment processed successfully: $" + payment.getAmount());
    }

    @Override
    public Payment getPaymentById(int paymentId) throws PaymentException {
        return null;
    }

    @Override
    public List<Payment> getAllPayments() throws PaymentException {
        if (payments.isEmpty()) {
            throw new PaymentException("No payments found.");
        }
        return payments;
    }
    @Override
    public void paymentOperations() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Process Payment");
            System.out.println("2. Display Payments");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Payment ID: ");
                    int paymentId = scanner.nextInt();
                    System.out.print("Enter Ride ID: ");
                    int rideId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Payment Method (Cash/Card): ");
                    String paymentMethod = scanner.nextLine();

                    try {
                        processPayment(new Payment(paymentId, rideId, userId, amount, paymentMethod, "Completed"));
                    } catch (PaymentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        getAllPayments().forEach(payment -> System.out.println("Payment ID: " + payment.getPaymentId()));
                    } catch (PaymentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
            }
        } while (choice != 3);
    }
}

