package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;

import java.util.List;
import java.util.Optional;

public class RideController {
    private final RideService rideService;

    // Constructor Injection for RideService
    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    // Book a Ride
    public void bookRide(Ride ride) {
        try {
            rideService.bookRide(ride);
            System.out.println(" Ride booked successfully!");
        } catch (Exception e) {
            System.err.println(" Error booking ride: " + e.getMessage());
        }
    }

    // Get All Rides
    public List<Ride> getAllRides() {
        try {
            return rideService.getAllRides();
        } catch (Exception e) {
            System.err.println(" Error fetching rides: " + e.getMessage());
        }
        return null;
    }

    // Get Ride By ID
    public Optional<Ride> getRideById(int rideId) {
        try {
            return rideService.getRideById(rideId);
        } catch (Exception e) {
            System.err.println(" Error fetching ride: " + e.getMessage());
            return null;
        }
    }

    // Update Ride Status
    public void updateRideStatus(int rideId, String status) {
        try {
            rideService.updateRideStatus(rideId, status);
            System.out.println(" Ride status updated successfully!");
        } catch (Exception e) {
            System.err.println(" Error updating ride status: " + e.getMessage());
        }
    }

    // Delete Ride
    public void deleteRide(int rideId) {
        try {
            rideService.deleteRide(rideId);
            System.out.println(" Ride deleted successfully!");
        } catch (Exception e) {
            System.err.println(" Error deleting ride: " + e.getMessage());
        }
    }
}




