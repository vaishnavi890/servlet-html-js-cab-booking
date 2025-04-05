package com.vaishnavi.servlet.cab.booking.repository;

import com.vaishnavi.servlet.cab.booking.model.Payment;
import com.vaishnavi.servlet.cab.booking.connection.JdbcConnection;

import java.sql.*;
import java.util.*;

public class PaymentRepository {

    public boolean insertPayment(Payment payment) {
        String sql = "INSERT INTO payments (ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, payment.getRideId());
            ps.setInt(2, payment.getUserId());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); return false;
        }
    }

    public List<Payment> getAllPayments() {
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_method"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}



