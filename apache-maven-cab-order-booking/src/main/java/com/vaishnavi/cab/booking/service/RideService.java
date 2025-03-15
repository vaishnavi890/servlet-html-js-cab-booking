package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RideService {
    private List<Ride> rides = new ArrayList<>();

    // Add Ride
    public void addRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride added successfully!");
    }

    // Get All Rides
    public List<Ride> getAllRides() {
        return rides;
    }

    // Find Ride by ID
    public Ride findRideById(int rideId) {
        Optional<Ride> ride = rides.stream()
                .filter(r -> r.getRideId() == rideId)
                .findFirst();
        if (ride.isPresent()) {
            return ride.get();
        } else {
            System.out.println("Ride not found.");
            return null;
        }
    }

    // Remove Ride by ID
    public void removeRide(int rideId) {
        if (rides.removeIf(r -> r.getRideId() == rideId)) {
            System.out.println("Ride removed successfully!");
        } else {
            System.out.println("Ride not found.");
        }
    }
}
