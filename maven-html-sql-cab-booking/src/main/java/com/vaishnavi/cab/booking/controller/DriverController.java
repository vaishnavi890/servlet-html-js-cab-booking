package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;

import java.util.List;
import java.util.Optional;

public class DriverController {
    private final DriverService driverService;

    // Constructor Injection for DriverService
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    // Add Driver
    public void addDriver(Driver driver) {
        try {
            driverService.addDriver(driver);
            System.out.println(" Driver registered successfully!");
        } catch (Exception e) {
            System.err.println("Error registering driver: " + e.getMessage());
        }
    }

    // Get All Drivers
    public List<Driver> getAllDrivers() {
        try {
            return driverService.getAllDrivers();
        } catch (Exception e) {
            System.err.println(" Error fetching drivers: " + e.getMessage());
        }
        return null;
    }

    // Get Driver By ID
    public Optional<Driver> getDriverById(int driverId) {
        try {
            return driverService.getDriverById(driverId);
        } catch (Exception e) {
            System.err.println(" Error fetching driver: " + e.getMessage());
            return null;
        }
    }

    // Update Driver Details
    public void updateDriver(int driverId, String name, String email, String phone, String cabDetails) {
        try {
            driverService.updateDriver(driverId, name, email, phone, cabDetails);
            System.out.println(" Driver details updated successfully!");
        } catch (Exception e) {
            System.err.println(" Error updating driver: " + e.getMessage());
        }
    }

    // Delete Driver
    public void deleteDriver(int driverId) {
        try {
            driverService.deleteDriver(driverId);
            System.out.println("Driver deleted successfully!");
        } catch (Exception e) {
            System.err.println("Error deleting driver: " + e.getMessage());
        }
    }
}




