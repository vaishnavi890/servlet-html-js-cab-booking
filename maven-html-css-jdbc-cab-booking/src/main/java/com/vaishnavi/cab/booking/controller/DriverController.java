package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;

import java.util.List;
import java.util.Optional;

public class DriverController {
    private DriverService driverService = null;

    public DriverController() {
        this.driverService = driverService;
    }

    public void addDriver() {
        try {
            Driver driver = new Driver();
            driverService.saveDriver(driver);
            System.out.println("Driver added successfully.");
        } catch (Exception e) {
            System.err.println("Error adding driver: " + e.getMessage());
        }
    }

    public void getDriverById(int driverId) {
        try {
            Optional<Driver> driver = driverService.getDriverById(driverId);
            driver.ifPresentOrElse(
                    d -> System.out.println("Driver found: " + d),
                    () -> System.out.println("Driver not found.")
            );
        } catch (Exception e) {
            System.err.println("Error fetching driver: " + e.getMessage());
        }
    }

    public void getAllDrivers() {
        try {
            List<Driver> drivers = driverService.getAllDrivers();
            drivers.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching drivers: " + e.getMessage());
        }
    }

    public void updateDriver() {
        try {
            Driver driver = new Driver();
            driverService.updateDriver(driver);
            System.out.println("Driver updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating driver: " + e.getMessage());
        }
    }

    public void deleteDriver() {
        try {
            int driverId = 0;
            driverService.deleteDriver(driverId);
            System.out.println("Driver deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting driver: " + e.getMessage());
        }
    }
}
