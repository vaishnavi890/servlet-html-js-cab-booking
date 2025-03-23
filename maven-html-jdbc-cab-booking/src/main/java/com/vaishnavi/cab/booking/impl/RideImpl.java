package com.vaishnavi.cab.booking.impl;

import com.vaishnavi.cab.booking.model.Ride;
import java.util.List;
import java.util.Optional;


public interface RideImpl {
    void addRide(Ride ride);
    Optional<Ride> getRideById(int rideId);
    List<Ride> getAllRides();
    void updateRide(Ride ride);
    void deleteRide(int rideId);
}
