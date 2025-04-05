package com.vaishnavi.servlet.cab.booking.controller;

import com.vaishnavi.servlet.cab.booking.model.Ride;
import com.vaishnavi.servlet.cab.booking.service.RideService;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;

public class RideController extends HttpServlet {

    private final RideService rideService = new RideService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String method = req.getMethod();
        if ("GET".equalsIgnoreCase(method)) {
            doGet(req, resp);
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost(req, resp);
        } else if ("DELETE".equalsIgnoreCase(method)) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Ride> rides = rideService.getAllRides();
        PrintWriter out = resp.getWriter();
        rides.forEach(ride -> out.println("<p>" + ride + "</p>"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = Integer.parseInt(req.getParameter("user_id"));
        int driverId = Integer.parseInt(req.getParameter("driver_id"));
        String pickup = req.getParameter("pickup_location");
        String dropoff = req.getParameter("dropoff_location");

        Ride ride = new Ride(0, userId, driverId, pickup, dropoff, 0.0, "Booked");
        rideService.bookRide(ride);
        resp.getWriter().println("Ride booked successfully!");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int rideId = Integer.parseInt(req.getParameter("ride_id"));
        boolean removed = rideService.deleteRide(rideId);
        resp.getWriter().println(removed ? "Ride deleted" : "Deletion failed");
    }

    @Override
    public void destroy() {
        System.out.println("RideController destroyed.");
    }
}


