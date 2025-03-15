package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RideRepository {
    private List<Ride> rides = new ArrayList<>();

    // Save a new ride
    public void saveRide(Ride ride) {
        rides.add(ride);
        System.out.println("Ride saved successfully!");
    }

    // Get all rides
    public List<Ride> findAllRides() {
        return new ArrayList<>(rides);
    }

    // Find ride by ID
    public Optional<Ride> findRideById(int rideId) {
        return rides.stream()
                .filter(ride -> ride.getRideId() == rideId)
                .findFirst();
    }

    // Remove ride by ID
    public boolean deleteRideById(int rideId) {
        return rides.removeIf(ride -> ride.getRideId() == rideId);
    }
}

