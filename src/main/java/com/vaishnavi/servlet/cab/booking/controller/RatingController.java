package com.vaishnavi.servlet.cab.booking.controller;

import com.vaishnavi.servlet.cab.booking.model.Rating;
import com.vaishnavi.servlet.cab.booking.service.RatingService;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;

public class RatingController extends HttpServlet {

    private final RatingService ratingService = new RatingService();

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
        List<Rating> ratings = ratingService.getAllRatings();
        PrintWriter out = resp.getWriter();
        ratings.forEach(rating -> out.println("<p>" + rating + "</p>"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int rideId = Integer.parseInt(req.getParameter("ride_id"));
        int userId = Integer.parseInt(req.getParameter("user_id"));
        int driverId = Integer.parseInt(req.getParameter("driver_id"));
        int ratingValue = Integer.parseInt(req.getParameter("rating"));
        String review = req.getParameter("review");

        Rating rating = new Rating(0, rideId, userId, driverId, ratingValue, review);
        ratingService.rateDriver(rating);
        resp.getWriter().println("Rating submitted!");
    }

    @Override
    public void destroy() {
        System.out.println("RatingController destroyed.");
    }
}


