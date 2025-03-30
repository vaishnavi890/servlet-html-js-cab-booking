package com.vaishnavi.cab.booking.controller;



import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RideController extends HttpServlet {

    private static final RideService rideService = new RideService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doPost() method: Ride Booking =========");

        int userId = Integer.parseInt(request.getParameter("user_id"));
        int driverId = Integer.parseInt(request.getParameter("driver_id"));
        String pickupLocation = request.getParameter("pickup_location");
        String dropoffLocation = request.getParameter("dropoff_location");
        double fare = Double.parseDouble(request.getParameter("fare"));

        Ride ride = new Ride(0, userId, driverId, pickupLocation, dropoffLocation, fare, "Booked");
        boolean isBooked = rideService.bookRide(ride);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + (isBooked ? "Ride Booked Successfully!" : "Ride Booking Failed!") + "</h1>");
        writer.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doGet() method: Fetch Rides =========");

        List<Ride> rides = rideService.getAllRides();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body><h2>Rides List</h2><ul>");
        for (Ride ride : rides) {
            writer.println("<li>Ride ID: " + ride.getRideId() + " | User: " + ride.getUserId() + " | Driver: " + ride.getDriverId() + "</li>");
        }
        writer.println("</ul></body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("========= Inside the destroy() method: RideController =========");
    }
}

