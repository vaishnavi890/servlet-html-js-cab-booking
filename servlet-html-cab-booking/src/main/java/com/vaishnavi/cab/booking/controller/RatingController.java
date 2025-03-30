package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RatingController extends HttpServlet {

    private static final RatingService ratingService = new RatingService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doPost() method: Submit Rating =========");

        int rideId = Integer.parseInt(request.getParameter("ride_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int driverId = Integer.parseInt(request.getParameter("driver_id"));
        int ratingValue = Integer.parseInt(request.getParameter("rating"));
        String review = request.getParameter("review");

        Rating rating = new Rating(0, rideId, userId, driverId, ratingValue, review);
        boolean isSubmitted = ratingService.submitRating(rating);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + (isSubmitted ? "Rating Submitted Successfully!" : "Rating Submission Failed!") + "</h1>");
        writer.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doGet() method: Fetch Ratings for Driver =========");

        int driverId = Integer.parseInt(request.getParameter("driver_id"));
        List<Rating> ratings = ratingService.getRatingsByDriver(driverId);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body><h2>Driver Ratings</h2><ul>");
        for (Rating rating : ratings) {
            writer.println("<li>Ride ID: " + rating.getRideId() + " | Rating: " + rating.getRating() + " | Review: " + rating.getReview() + "</li>");
        }
        writer.println("</ul></body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("========= Inside the destroy() method: RatingController =========");
    }
}



