package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import java.util.List;
import java.util.Optional;

public interface RideServiceInterface {
    void bookRide(Ride ride);
    List<Ride> getAllRides();
    Optional<Ride> getRideById(int rideId);
    void updateRideStatus(int rideId, String status);
    void deleteRide(int rideId);
}


