package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.impl.DriverServiceImpl;
import com.vaishnavi.cab.booking.exception.DriverException;
import java.util.List;

public class DriverController {
    private final DriverServiceImpl driverService = new DriverServiceImpl();

    public DriverController() {
    }

    public void registerDriver(int driverId, String name, String email, String phone, String cabDetails) {
        try {
            if (name == null || name.isEmpty()) {
                throw new DriverException("Driver name cannot be empty!");
            }
            Driver driver = new Driver(driverId, name, email, phone);
            driverService.add(driver);
            System.out.println("Driver Registered: " + name);
        } catch (DriverException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public void displayDrivers() {
        try {
            List<Driver> drivers = driverService.getAll();
            if (drivers.isEmpty()) {
                throw new DriverException("No drivers found.");
            }
            System.out.println("Registered Drivers:");
            drivers.forEach(driver -> System.out.println("Driver ID: " + driver.getDriverId() + ", Name: " + driver.getName()));
        } catch (DriverException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public void registerDriver(Driver driver) {
    }
}
