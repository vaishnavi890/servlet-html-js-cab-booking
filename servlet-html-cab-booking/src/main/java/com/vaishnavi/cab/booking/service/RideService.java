package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;
import java.util.List;

public class RideService {

    private final RideRepository rideRepository = new RideRepository();

    public boolean bookRide(Ride ride) {
        if (ride.getUserId() <= 0 || ride.getDriverId() <= 0) {
            throw new IllegalArgumentException("Invalid user or driver ID!");
        }
        if (ride.getPickupLocation() == null || ride.getDropoffLocation() == null) {
            throw new IllegalArgumentException("Pickup and Drop-off locations are required!");
        }
        return rideRepository.addRide(ride);
    }

    public List<Ride> getAllRides() {
        return rideRepository.getRides();
    }

    public boolean updateRideStatus(int rideId, String status) {
        return rideRepository.updateRideStatus(rideId, status);
    }
}

