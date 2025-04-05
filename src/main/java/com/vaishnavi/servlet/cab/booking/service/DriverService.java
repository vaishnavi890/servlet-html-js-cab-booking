package com.vaishnavi.servlet.cab.booking.service;

import com.vaishnavi.servlet.cab.booking.model.Driver;
import com.vaishnavi.servlet.cab.booking.repository.DriverRepository;

import java.util.List;

public class DriverService {
    private final DriverRepository repo = new DriverRepository();

    public boolean addDriver(Driver driver) {
        return repo.insertDriver(driver);
    }

    public boolean deleteDriver(int driverId) {
        return repo.removeDriver(driverId);
    }

    public List<Driver> getAllDrivers() {
        return repo.getAllDrivers();
    }
}


