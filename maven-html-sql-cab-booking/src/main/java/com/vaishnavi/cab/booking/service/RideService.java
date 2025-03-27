package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;
import java.util.List;
import java.util.Optional;

public class RideService implements RideServiceInterface {
    private RideRepository rideRepository = new RideRepository();

    public RideService(RideRepository rideRepository) {
    }

    @Override
    public void bookRide(Ride ride) {
        rideRepository.addRide(ride);
    }

    @Override
    public List<Ride> getAllRides() {
        return rideRepository.getAllRides();
    }

    @Override
    public Optional<Ride> getRideById(int rideId) {
        return Optional.ofNullable(rideRepository.getRideById(rideId));
    }

    @Override
    public void updateRideStatus(int rideId, String status) {
        rideRepository.updateRideStatus(rideId, status);
    }

    @Override
    public void deleteRide(int rideId) {
        rideRepository.deleteRide(rideId);
    }
}


