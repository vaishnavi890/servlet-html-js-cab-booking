package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import java.util.HashMap;
import java.util.Map;

public class DriverRepository {
    private Map<String, Driver> driverMap = new HashMap<>();

    public void addDriver(Driver driver) {
        driverMap.put(driver.getDriverId(), driver);
    }

    public Driver getDriver(String driverId) {
        return driverMap.get(driverId);
    }

    public void removeDriver(String driverId) {
        driverMap.remove(driverId);
    }

    public boolean containsDriver(String driverId) {
        return driverMap.containsKey(driverId);
    }

    public Map<String, Driver> getAllDrivers() {
        return driverMap;
    }
}

