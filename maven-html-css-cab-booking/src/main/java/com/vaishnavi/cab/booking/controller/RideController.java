package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;

import java.util.List;
import java.util.Optional;

public class RideController {
    private RideService rideService = null;

    public RideController() {
        this.rideService = rideService;
    }

    public void addRide() {
        try {
            Ride ride = new Ride();
            rideService.saveRide(ride);
            System.out.println("Ride added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding ride: " + e.getMessage());
        }
    }

    public void getRideById(int rideId) {
        try {
            Optional<Ride> ride = rideService.getRideById(rideId);
            ride.ifPresentOrElse(
                    r -> System.out.println("Ride found: " + r),
                    () -> System.out.println("Ride not found.")
            );
        } catch (Exception e) {
            System.err.println("Error fetching ride: " + e.getMessage());
        }
    }

    public void getAllRides() {
        try {
            List<Ride> rides = rideService.getAllRides();
            rides.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching rides: " + e.getMessage());
        }
    }

    public void updateRide() {
        try {
            Ride ride = new Ride();
            rideService.updateRide(ride);
            System.out.println("Ride updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating ride: " + e.getMessage());
        }
    }

    public void deleteRide() {
        try {
            int rideId = 0;
            rideService.deleteRide(rideId);
            System.out.println("Ride deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting ride: " + e.getMessage());
        }
    }
}
