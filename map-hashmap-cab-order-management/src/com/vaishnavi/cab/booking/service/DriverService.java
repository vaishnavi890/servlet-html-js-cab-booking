package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;

public class DriverService {
    private DriverRepository driverRepository = new DriverRepository();

    public void registerDriver(Driver driver) {
        if (!driverRepository.containsDriver(driver.getDriverId())) {
            driverRepository.addDriver(driver);
            System.out.println("Driver registered successfully!");
        } else {
            System.out.println("Driver already exists!");
        }
    }

    public void displayDrivers() {
        driverRepository.getAllDrivers().forEach((key, value) ->
                System.out.println("Key: " + key + ", Value: " + value));
    }
}

