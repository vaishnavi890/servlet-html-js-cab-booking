package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.impl.RideImpl;
import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;

import java.util.*;
import java.util.stream.Collectors;

public class RideService implements RideImpl {
    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public void addRide(Ride ride) {
        try {
            rideRepository.save(ride);
            System.out.println("Ride added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding ride: " + e.getMessage());
        }
    }

    @Override
    public Optional<Ride> getRideById(int rideId) {
        return rideRepository.findById(rideId);
    }

    @Override
    public List<Ride> getAllRides() {
        return rideRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void updateRide(Ride ride) {
        try {
            rideRepository.update(ride);
            System.out.println("Ride updated successfully!");
        } catch (Exception e) {
            System.err.println("Error updating ride: " + e.getMessage());
        }
    }

    @Override
    public void deleteRide(int rideId) {
        try {
            rideRepository.delete(rideId);
            System.out.println("Ride deleted successfully!");
        } catch (Exception e) {
            System.err.println("Error deleting ride: " + e.getMessage());
        }
    }

    @Override
    public void saveRide(Ride ride) {

    }
}
