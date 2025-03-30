package com.vaishnavi.cab.booking.service;


import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;
import java.util.List;

public class DriverService {

    private final DriverRepository driverRepository = new DriverRepository();

    public boolean registerDriver(Driver driver) {
        if (driver.getName() == null || driver.getName().isBlank()) {
            throw new IllegalArgumentException("Driver name cannot be empty!");
        }
        if (driver.getCabDetails() == null || driver.getCabDetails().isBlank()) {
            throw new IllegalArgumentException("Cab details are required!");
        }
        return driverRepository.addDriver(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.getDrivers();
    }
}
