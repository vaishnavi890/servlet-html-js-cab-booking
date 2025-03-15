package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DriverService {
    private List<Driver> drivers = new ArrayList<>();

    // Add Driver
    public void addDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Driver added successfully!");
    }

    // Get All Drivers
    public List<Driver> getAllDrivers() {
        return drivers;
    }

    // Find Driver by ID
    public Driver findDriverById(int driverId) {
        Optional<Driver> driver = drivers.stream()
                .filter(d -> d.getDriverId() == driverId)
                .findFirst();
        if (driver.isPresent()) {
            return driver.get();
        } else {
            System.out.println("Driver not found.");
            return null;
        }
    }

    // Remove Driver by ID
    public void removeDriver(int driverId) {
        if (drivers.removeIf(d -> d.getDriverId() == driverId)) {
            System.out.println("Driver removed successfully!");
        } else {
            System.out.println("Driver not found.");
        }
    }
}
