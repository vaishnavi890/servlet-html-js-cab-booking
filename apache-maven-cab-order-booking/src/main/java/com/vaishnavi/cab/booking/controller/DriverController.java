package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;

import java.util.List;


public class DriverController {
    private DriverService driverService = new DriverService();

    // Add Driver
    public void addDriver(Driver driver) {
        driverService.addDriver(driver);
    }

    // Get All Drivers
    public void getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        drivers.forEach(System.out::println);
    }

    // Find Driver by ID
    public void getDriverById(int driverId) {
        Driver driver = driverService.findDriverById(driverId);
        if (driver != null) {
            System.out.println(driver);
        } else {
            System.out.println("Driver not found.");
        }
    }

    // Delete Driver by ID
    public void deleteDriverById(int driverId) {
        driverService.removeDriver(driverId);
    }
}
