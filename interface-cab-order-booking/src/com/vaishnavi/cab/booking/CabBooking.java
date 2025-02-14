package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.controller.UserController;
import com.vaishnavi.cab.booking.controller.DriverController;
import com.vaishnavi.cab.booking.controller.RideController;
import com.vaishnavi.cab.booking.controller.PaymentController;
import com.vaishnavi.cab.booking.controller.RatingController;
import com.vaishnavi.cab.booking.exception.PaymentException;
import java.util.Scanner;

public class CabBooking {
        public static void main (String[]args) throws PaymentException {
            Scanner scanner = new Scanner(System.in);
            UserController userController = new UserController();
            DriverController driverController = new DriverController();
            RideController rideController = new RideController();
            PaymentController paymentController = new PaymentController();
            RatingController ratingController = new RatingController();

            int choice;
            do {
                System.out.println("\n=== CAB ORDER MANAGEMENT SYSTEM ===");
                System.out.println("1. Register User");
                System.out.println("2. Register Driver");
                System.out.println("3. Book Ride");
                System.out.println("4. Process Payment");
                System.out.println("5. Submit Rating");
                System.out.println("6. Display All Users");
                System.out.println("7. Display All Drivers");
                System.out.println("8. Display All Rides");
                System.out.println("9. Display All Payments");
                System.out.println("10. Display All Ratings");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String userName = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String userEmail = scanner.nextLine();
                        System.out.print("Enter Phone: ");
                        String userPhone = scanner.nextLine();
                        userController.registerUser(userId, userName, userEmail, userPhone);
                        break;

                    case 2:
                        System.out.print("Enter Driver ID: ");
                        int driverId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String driverName = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String driverEmail = scanner.nextLine();
                        System.out.print("Enter Phone: ");
                        String driverPhone = scanner.nextLine();
                        System.out.print("Enter Cab Details: ");
                        String cabDetails = scanner.nextLine();
                        driverController.registerDriver(driverId, driverName, driverEmail, driverPhone, cabDetails);
                        break;

                    case 3:
                        System.out.print("Enter Ride ID: ");
                        int rideId = scanner.nextInt();
                        System.out.print("Enter User ID: ");
                        int rUserId = scanner.nextInt();
                        System.out.print("Enter Driver ID: ");
                        int rDriverId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Pickup Location: ");
                        String pickup = scanner.nextLine();
                        System.out.print("Enter Dropoff Location: ");
                        String dropoff = scanner.nextLine();
                        System.out.print("Enter Fare: ");
                        double fare = scanner.nextDouble();
                        rideController.bookRide(rideId, rUserId, rDriverId, pickup, dropoff, fare, "Pending");
                        break;

                    case 4:
                        System.out.print("Enter Payment ID: ");
                        int paymentId = scanner.nextInt();
                        System.out.print("Enter Ride ID: ");
                        int pRideId = scanner.nextInt();
                        System.out.print("Enter User ID: ");
                        int pUserId = scanner.nextInt();
                        System.out.print("Enter Amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Payment Method: ");
                        String paymentMethod = scanner.nextLine();
                        paymentController.processPayment(paymentId, pRideId, pUserId, amount, paymentMethod, "Success");
                        break;

                    case 5:
                        System.out.print("Enter Rating ID: ");
                        int ratingId = scanner.nextInt();
                        System.out.print("Enter Ride ID: ");
                        int rateRideId = scanner.nextInt();
                        System.out.print("Enter User ID: ");
                        int rateUserId = scanner.nextInt();
                        System.out.print("Enter Driver ID: ");
                        int rateDriverId = scanner.nextInt();
                        System.out.print("Enter Rating (1-5): ");
                        int rating = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Review: ");
                        String review = scanner.nextLine();
                        ratingController.submitRating(ratingId, rateRideId, rateUserId, rateDriverId, rating, review);
                        break;

                    case 6:
                        userController.displayUsers();
                        break;

                    case 7:
                        driverController.displayDrivers();
                        break;

                    case 8:
                        rideController.displayRides();
                        break;

                    case 9:
                        paymentController.displayPayments();
                        break;

                    case 10:
                        ratingController.displayRatings();
                        break;

                    case 0:
                        System.out.println("Exiting the system...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            } while (choice != 0);

            scanner.close();
        }
    }