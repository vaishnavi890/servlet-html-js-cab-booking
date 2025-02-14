package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.service.RideService;
import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.exception.RideException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RideServiceImpl implements RideService {
    private final List<Ride> rides = new ArrayList<>();

    @Override
    public void bookRide(Ride ride) throws RideException {
        if (ride == null || ride.getPickupLocation().isEmpty() || ride.getDropoffLocation().isEmpty()) {
            throw new RideException("Invalid ride details!");
        }
        rides.add(ride);
        System.out.println("Ride booked successfully: " + ride.getRideId());
    }

    @Override
    public Ride getRideById(int rideId) throws RideException {
        return null;
    }

    @Override
    public List<Ride> getAllRides() {
        if (rides.isEmpty()) {
             new RideException("No rides found.");
        }
        return rides;
    }

    @Override
    public void updateRideStatus(int rideId, String status) throws RideException {

    }

    @Override
    public void rideOperations() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Book Ride");
            System.out.println("2. Display Rides");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ride ID: ");
                    int rideId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Pickup Location: ");
                    String pickup = scanner.nextLine();
                    System.out.print("Enter Drop-off Location: ");
                    String dropoff = scanner.nextLine();

                    try {
                        bookRide(new Ride(rideId, pickup, dropoff));
                    } catch (RideException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    getAllRides().forEach(ride -> System.out.println(ride.getRideId()));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (true);
    }
}
