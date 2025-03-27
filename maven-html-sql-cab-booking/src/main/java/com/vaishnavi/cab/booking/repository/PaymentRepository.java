package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.connection.DBConnection;

import java.sql.*;
import java.util.*;

public class PaymentRepository {
    private Map<Integer, Payment> paymentCache = new HashMap<>();

    // Add a new payment
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO Payments (ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, payment.getRideId());
            stmt.setInt(2, payment.getUserId());
            stmt.setDouble(3, payment.getAmount());
            stmt.setString(4, payment.getPaymentMethod());
            stmt.setString(5, payment.getStatus());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                payment.setPaymentId(rs.getInt(1));
                paymentCache.put(payment.getPaymentId(), payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payments";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_method"),
                        rs.getString("status")
                );
                payments.add(payment);
                paymentCache.put(payment.getPaymentId(), payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    // Get payment by ID
    public Payment getPaymentById(int paymentId) {
        return paymentCache.getOrDefault(paymentId, null);
    }

    // Update payment status
    public void updatePaymentStatus(int paymentId, String status) {
        String sql = "UPDATE Payments SET status=? WHERE payment_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, paymentId);
            stmt.executeUpdate();

            if (paymentCache.containsKey(paymentId)) {
                Payment payment = paymentCache.get(paymentId);
                payment.setStatus(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete payment
    public void deletePayment(int paymentId) {
        String sql = "DELETE FROM Payments WHERE payment_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, paymentId);
            stmt.executeUpdate();
            paymentCache.remove(paymentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


