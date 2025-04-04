package com.vaishnavi.servlet.cab.booking.service;

import com.vaishnavi.servlet.cab.booking.model.Ride;
import com.vaishnavi.servlet.cab.booking.repository.RideRepository;

import java.util.List;

public class RideService {
    private final RideRepository repo = new RideRepository();

    public void bookRide(Ride ride) {
        repo.insertRide(ride);
    }

    public boolean deleteRide(int rideId) {
        return repo.removeRide(rideId);
    }

    public List<Ride> getAllRides() {
        return repo.getAllRides();
    }
}


