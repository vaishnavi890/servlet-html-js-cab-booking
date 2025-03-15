package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DriverRepository {
    private List<Driver> drivers = new ArrayList<>();

    // Save a new driver
    public void saveDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Driver saved successfully!");
    }

    // Get all drivers
    public List<Driver> findAllDrivers() {
        return new ArrayList<>(drivers);
    }

    // Find driver by ID
    public Optional<Driver> findDriverById(int driverId) {
        return drivers.stream()
                .filter(driver -> driver.getDriverId() == driverId)
                .findFirst();
    }

    // Remove driver by ID
    public boolean deleteDriverById(int driverId) {
        return drivers.removeIf(driver -> driver.getDriverId() == driverId);
    }
}
