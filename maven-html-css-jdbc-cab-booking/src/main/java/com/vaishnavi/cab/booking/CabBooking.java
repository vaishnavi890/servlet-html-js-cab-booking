package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.controller.*;

import java.util.Scanner;

public class CabBooking
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" Welcome to Cab Booking Management System ");

        UserController userController = new UserController();
        DriverController driverController = new DriverController();
        RideController rideController = new RideController();
        PaymentController paymentController = new PaymentController();
        RatingController ratingController = new RatingController();

        while (true) {
            System.out.println("\n--------- Main Menu ------------");
            System.out.println("1. User Operations");
            System.out.println("2. Driver Operations");
            System.out.println("3. Ride Operations");
            System.out.println("4. Payment Operations");
            System.out.println("5. Rating Operations");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    userOperations(userController);
                    break;
                case 2:
                    driverOperations(driverController);
                    break;
                case 3:
                    rideOperations(rideController);
                    break;
                case 4:
                    paymentOperations(paymentController);
                    break;
                case 5:
                    ratingOperations(ratingController);
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userOperations(UserController userController) {
        System.out.println("\n--- User Operations ---");
        System.out.println("1. Add User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. View All Users");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> userController.addUser();
            case 2 -> userController.updateUser();
            case 3 -> userController.deleteUser();
            case 4 -> userController.getAllUsers();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void driverOperations(DriverController driverController) {
        System.out.println("\n--- Driver Operations ---");
        System.out.println("1. Add Driver");
        System.out.println("2. Update Driver");
        System.out.println("3. Delete Driver");
        System.out.println("4. View All Drivers");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> driverController.addDriver();
            case 2 -> driverController.updateDriver();
            case 3 -> driverController.deleteDriver();
            case 4 -> driverController.getAllDrivers();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void rideOperations(RideController rideController) {
        System.out.println("\n--- Ride Operations ---");
        System.out.println("1. Add Ride");
        System.out.println("2. Update Ride");
        System.out.println("3. Delete Ride");
        System.out.println("4. View All Rides");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> rideController.addRide();
            case 2 -> rideController.updateRide();
            case 3 -> rideController.deleteRide();
            case 4 -> rideController.getAllRides();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void paymentOperations(PaymentController paymentController) {
        System.out.println("\n--- Payment Operations ---");
        System.out.println("1. Add Payment");
        System.out.println("2. Update Payment");
        System.out.println("3. Delete Payment");
        System.out.println("4. View All Payments");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> paymentController.addPayment();
            case 2 -> paymentController.updatePayment();
            case 3 -> paymentController.deletePayment();
            case 4 -> paymentController.getAllPayments();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void ratingOperations(RatingController ratingController) {
        System.out.println("\n--- Rating Operations ---");
        System.out.println("1. Add Rating");
        System.out.println("2. Update Rating");
        System.out.println("3. Delete Rating");
        System.out.println("4. View All Ratings");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> ratingController.addRating();
            case 2 -> ratingController.updateRating();
            case 3 -> ratingController.deleteRating();
            case 4 -> ratingController.getAllRatings();
            default -> System.out.println("Invalid choice.");
        }
    }
}


