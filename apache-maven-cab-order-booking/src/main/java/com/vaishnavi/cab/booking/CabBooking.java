package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.controller.*;
import com.vaishnavi.cab.booking.model.*;

import java.util.Scanner;

public class CabBooking
{
    private static final UserController userController = new UserController();
    private static final DriverController driverController = new DriverController();
    private static final RideController rideController = new RideController();
    private static final PaymentController paymentController = new PaymentController();
    private static final RatingController ratingController = new RatingController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Cab Order Management System ===");
            System.out.println("1. Add User");
            System.out.println("2. Add Driver");
            System.out.println("3. Add Ride");
            System.out.println("4. Add Payment");
            System.out.println("5. Add Rating");
            System.out.println("6. View All Users");
            System.out.println("7. View All Drivers");
            System.out.println("8. View All Rides");
            System.out.println("9. View All Payments");
            System.out.println("10. View All Ratings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                addUser();
            } else if (choice == 2) {
                addDriver();
            } else if (choice == 3) {
                addRide();
            } else if (choice == 4) {
                addPayment();
            } else if (choice == 5) {
                addRating();
            } else if (choice == 6) {
                userController.getAllUsers();
            } else if (choice == 7) {
                driverController.getAllDrivers();
            } else if (choice == 8) {
                rideController.getAllRides();
            } else if (choice == 9) {
                paymentController.getAllPayments();
            } else if (choice == 10) {
                ratingController.getAllRatings();
            } else if (choice == 0) {
                System.out.println("Exiting the system. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void addUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        User user = new User(userId, name, email, phone);
        userController.addUser(user);
    }

    private static void addDriver() {
        System.out.print("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Cab Details: ");
        String cabDetails = scanner.nextLine();
        Driver driver = new Driver(driverId, name, email, phone, cabDetails);
        driverController.addDriver(driver);
    }

    private static void addRide() {
        System.out.print("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Pickup Location: ");
        String pickup = scanner.nextLine();
        System.out.print("Enter Dropoff Location: ");
        String dropoff = scanner.nextLine();
        System.out.print("Enter Fare: ");
        double fare = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();
        Ride ride = new Ride(rideId, userId, driverId, pickup, dropoff, fare, status);
        rideController.addRide(ride);
    }

    private static void addPayment() {
        System.out.print("Enter Payment ID: ");
        int paymentId = scanner.nextInt();
        System.out.print("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Payment Method: ");
        String method = scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();
        Payment payment = new Payment(paymentId, rideId, userId, amount, method, status);
        paymentController.addPayment(payment);
    }

    private static void addRating() {
        System.out.print("Enter Rating ID: ");
        int ratingId = scanner.nextInt();
        System.out.print("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        System.out.print("Enter Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Review: ");
        String review = scanner.nextLine();
        Rating ratingObj = new Rating(ratingId, rideId, userId, driverId, rating, review);
        ratingController.addRating(ratingObj);
    }
}

