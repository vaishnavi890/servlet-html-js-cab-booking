package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.impl.DriverImpl;
import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;

import java.util.*;
import java.util.stream.Collectors;

public class DriverService implements DriverImpl {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void addDriver(Driver driver) {
        try {
            driverRepository.save(driver);
            System.out.println("Driver added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding driver: " + e.getMessage());
        }
    }

    @Override
    public Optional<Driver> getDriverById(int driverId) {
        return driverRepository.findById(driverId);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void updateDriver(Driver driver) {
        try {
            driverRepository.update(driver);
            System.out.println("Driver updated successfully!");
        } catch (Exception e) {
            System.err.println("Error updating driver: " + e.getMessage());
        }
    }

    @Override
    public void deleteDriver(int driverId) {
        try {
            driverRepository.delete(driverId);
            System.out.println("Driver deleted successfully!");
        } catch (Exception e) {
            System.err.println("Error deleting driver: " + e.getMessage());
        }
    }

    @Override
    public void saveDriver(Driver driver) {

    }
}
