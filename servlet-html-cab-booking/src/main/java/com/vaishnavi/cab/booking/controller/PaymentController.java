package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PaymentController extends HttpServlet {

    private static final PaymentService paymentService = new PaymentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doPost() method: Make Payment =========");

        int rideId = Integer.parseInt(request.getParameter("ride_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String paymentMethod = request.getParameter("payment_method");

        Payment payment = new Payment(0, rideId, userId, amount, paymentMethod, "Completed");
        boolean isPaid = paymentService.makePayment(payment);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + (isPaid ? "Payment Successful!" : "Payment Failed!") + "</h1>");
        writer.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doGet() method: Fetch Payment History =========");

        int userId = Integer.parseInt(request.getParameter("user_id"));
        List<Payment> payments = paymentService.getPaymentsByUser(userId);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body><h2>Payment History</h2><ul>");
        for (Payment payment : payments) {
            writer.println("<li>Payment ID: " + payment.getPaymentId() + " | Amount: " + payment.getAmount() + " | Status: " + payment.getStatus() + "</li>");
        }
        writer.println("</ul></body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("========= Inside the destroy() method: PaymentController =========");
    }
}



