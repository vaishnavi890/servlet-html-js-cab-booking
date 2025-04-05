package com.vaishnavi.servlet.cab.booking.controller;

import com.vaishnavi.servlet.cab.booking.model.Payment;
import com.vaishnavi.servlet.cab.booking.service.PaymentService;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;

public class PaymentController extends HttpServlet {

    private final PaymentService paymentService = new PaymentService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getMethod().equalsIgnoreCase("GET")) {
            doGet(req, resp);
        } else if (req.getMethod().equalsIgnoreCase("POST")) {
            doPost(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Payment> payments = paymentService.getAllPayments();
        PrintWriter out = resp.getWriter();
        payments.forEach(payment -> out.println("<p>" + payment + "</p>"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int rideId = Integer.parseInt(req.getParameter("ride_id"));
        int userId = Integer.parseInt(req.getParameter("user_id"));
        double amount = Double.parseDouble(req.getParameter("amount"));
        String method = req.getParameter("payment_method");

        Payment payment = new Payment(0, rideId, userId, amount, method, "Paid");
        paymentService.makePayment(payment);
        resp.getWriter().println("Payment done successfully!");
    }

    @Override
    public void destroy() {
        System.out.println("PaymentController destroyed.");
    }
}



