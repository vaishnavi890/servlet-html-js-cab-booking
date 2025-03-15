package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;

import java.util.List;

public class RideController {
    private RideService rideService = new RideService();

    // Add Ride
    public void addRide(Ride ride) {
        rideService.addRide(ride);
    }

    // Get All Rides
    public void getAllRides() {
        List<Ride> rides = rideService.getAllRides();
        rides.forEach(System.out::println);
    }

    // Find Ride by ID
    public void getRideById(int rideId) {
        Ride ride = rideService.findRideById(rideId);
        if (ride != null) {
            System.out.println(ride);
        } else {
            System.out.println("Ride not found.");
        }
    }

    // Delete Ride by ID
    public void deleteRideById(int rideId) {
        rideService.removeRide(rideId);
    }
}
