package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.exception.RatingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatingServiceImpl {
    private List<Rating> ratings = new ArrayList<>();

    public void submitRating(Rating rating) throws RatingException {
        if (rating == null || rating.getRating() < 1 || rating.getRating() > 5) {
            throw new RatingException("Invalid rating! Must be between 1 and 5.");
        }
        ratings.add(rating);
        System.out.println("Rating submitted successfully: " + rating.getRating() + " stars");
    }

    public List<Rating> getAllRatings() throws RatingException {
        if (ratings.isEmpty()) {
            throw new RatingException("No ratings found.");
        }
        return ratings;
    }
    public void ratingOperations() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Submit Rating");
            System.out.println("2. Display Ratings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Rating ID: ");
                    int ratingId = scanner.nextInt();
                    System.out.print("Enter Ride ID: ");
                    int rideId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Driver ID: ");
                    int driverId = scanner.nextInt();
                    System.out.print("Enter Rating (1-5): ");
                    int ratingValue = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Review: ");
                    String review = scanner.nextLine();

                    try {
                        submitRating(new Rating(ratingId, rideId, userId, driverId, ratingValue, review));
                    } catch (RatingException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        getAllRatings().forEach(rating -> System.out.println("Rating ID: " + rating.getRatingId()));
                    } catch (RatingException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
            }
        } while (choice != 3);
    }
}
