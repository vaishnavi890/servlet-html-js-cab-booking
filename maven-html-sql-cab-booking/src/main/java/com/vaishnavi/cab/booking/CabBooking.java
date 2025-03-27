package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.controller.*;
import com.vaishnavi.cab.booking.model.*;
import com.vaishnavi.cab.booking.service.*;
import com.vaishnavi.cab.booking.repository.*;

import java.util.Scanner;

public class CabBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize Repositories
        UserRepository userRepository = new UserRepository();
        DriverRepository driverRepository = new DriverRepository();
        RideRepository rideRepository = new RideRepository();
        PaymentRepository paymentRepository = new PaymentRepository();
        RatingRepository ratingRepository = new RatingRepository();

        // Initialize Services
        UserService userService = new UserService(userRepository);
        DriverService driverService = new DriverService(driverRepository);
        RideService rideService = new RideService(rideRepository);
        PaymentService paymentService = new PaymentService(paymentRepository);
        RatingService ratingService = new RatingService(ratingRepository);

        // Initialize Controllers
        UserController userController = new UserController(userService);
        DriverController driverController = new DriverController(driverService);
        RideController rideController = new RideController(rideService);
        PaymentController paymentController = new PaymentController(paymentService);
        RatingController ratingController = new RatingController(ratingService);

        while (true) {
            System.out.println("\n===== CAB ORDER MANAGEMENT SYSTEM =====");
            System.out.println("1. Register User");
            System.out.println("2. Register Driver");
            System.out.println("3. Book a Ride");
            System.out.println("4. Complete Payment");
            System.out.println("5. Rate a Ride");
            System.out.println("6. View All Rides");
            System.out.println("7. View All Payments");
            System.out.println("8. View All Ratings");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Register User
                    System.out.print("Enter Name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String userEmail = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String userPhone = scanner.nextLine();

                    User newUser = new User(0, userName, userEmail, userPhone);
                    userController.addUser(newUser);
                    break;

                case 2: // Register Driver
                    System.out.print("Enter Driver Name: ");
                    String driverName = scanner.nextLine();
                    System.out.print("Enter Driver Email: ");
                    String driverEmail = scanner.nextLine();
                    System.out.print("Enter Driver Phone: ");
                    String driverPhone = scanner.nextLine();
                    System.out.print("Enter Cab Details: ");
                    String cabDetails = scanner.nextLine();

                    Driver newDriver = new Driver(0, driverName, driverEmail, driverPhone, cabDetails);
                    driverController.addDriver(newDriver);
                    break;

                case 3: // Book a Ride
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Driver ID: ");
                    int driverId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Pickup Location: ");
                    String pickup = scanner.nextLine();
                    System.out.print("Enter Dropoff Location: ");
                    String dropoff = scanner.nextLine();
                    System.out.print("Enter Fare: ");
                    double fare = scanner.nextDouble();

                    Ride newRide = new Ride(0, userId, driverId, pickup, dropoff, fare, "Booked");
                    rideController.bookRide(newRide);
                    break;

                case 4: // Complete Payment
                    System.out.print("Enter Ride ID: ");
                    int rideId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int payUserId = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Payment Method (Cash/Card): ");
                    String method = scanner.nextLine();

                    Payment newPayment = new Payment(0, rideId, payUserId, amount, method, "Completed");
                    paymentController.addPayment(newPayment);
                    break;

                case 5: // Rate a Ride
                    System.out.print("Enter Ride ID: ");
                    int rateRideId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int rateUserId = scanner.nextInt();
                    System.out.print("Enter Driver ID: ");
                    int rateDriverId = scanner.nextInt();
                    System.out.print("Enter Rating (1-5): ");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Review: ");
                    String review = scanner.nextLine();

                    Rating newRating = new Rating(0, rateRideId, rateUserId, rateDriverId, rating, review);
                    ratingController.addRating(newRating);
                    break;

                case 6: // View All Rides
                    System.out.println(" All Rides:");
                    rideController.getAllRides().forEach(System.out::println);
                    break;

                case 7: // View All Payments
                    System.out.println("All Payments:");
                    paymentController.getAllPayments().forEach(System.out::println);
                    break;

                case 8: // View All Ratings
                    System.out.println(" All Ratings:");
                    ratingController.getAllRatings().forEach(System.out::println);
                    break;

                case 9: // Exit
                    System.out.println(" Thank you for using Cab Order Management System!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}



