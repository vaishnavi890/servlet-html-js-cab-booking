package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import java.util.HashMap;
import java.util.Map;


public class RideRepository {
    private Map<String, Ride> rideMap = new HashMap<>();

    public void addRide(Ride ride) {
        rideMap.put(ride.getRideId(), ride);
    }

    public Ride getRide(String rideId) {
        return rideMap.get(rideId);
    }

    public void removeRide(String rideId) {
        rideMap.remove(rideId);
    }

    public boolean containsRide(String rideId) {
        return rideMap.containsKey(rideId);
    }

    public int getRideCount() {
        return rideMap.size();
    }
}

