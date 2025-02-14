package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.impl.RideServiceImpl;
import com.vaishnavi.cab.booking.exception.RideException;
import java.util.List;


public class RideController {
    private RideServiceImpl rideService = new RideServiceImpl();

    public RideController() {
    }

    public void bookRide(int rideId, int userId, int driverId, String pickup, String dropoff, double fare, String status) {
        try {
            if (pickup == null || dropoff == null) {
                throw new RideException("Pickup and Dropoff locations cannot be null!");
            }
            Ride ride = new Ride(rideId, userId, driverId, pickup, dropoff, fare, status);
            rideService.bookRide(ride);
            System.out.println("Ride Booked Successfully! Ride ID: " + rideId);
        } catch (RideException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public void displayRides() {
        try {
            List<Ride> rides = rideService.getAllRides();
            if (rides.isEmpty()) {
                throw new RideException("No rides found.");
            }
            System.out.println("Ride Details:");
            rides.forEach(ride -> System.out.println("Ride ID: " + ride.getRideId() + ", Status: " + ride.getStatus()));
        } catch (RideException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public void bookRide(Ride pending) {
    }
}
