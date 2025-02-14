package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.exception.RideException;
import java.util.List;

public interface RideService  {
    void bookRide(Ride ride) throws RideException;
    Ride getRideById(int rideId) throws RideException;
    List<Ride> getAllRides();
    void updateRideStatus(int rideId, String status) throws RideException;

    void rideOperations();
}
