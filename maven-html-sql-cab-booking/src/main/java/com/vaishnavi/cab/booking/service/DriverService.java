package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;
import java.util.List;
import java.util.Optional;

public class DriverService implements DriverServiceInterface {
    private DriverRepository driverRepository = new DriverRepository();

    public DriverService(DriverRepository driverRepository) {
    }

    @Override
    public void registerDriver(Driver driver) {
        driverRepository.addDriver(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.getAllDrivers();
    }

    @Override
    public Optional<Driver> getDriverById(int driverId) {
        return Optional.ofNullable(driverRepository.getDriverById(driverId));
    }

    @Override
    public void updateDriver(int driverId, String name, String email, String phone, String cabDetails) {
        driverRepository.updateDriver(driverId, name, email, phone, cabDetails);
    }

    @Override
    public void deleteDriver(int driverId) {
        driverRepository.deleteDriver(driverId);
    }

    @Override
    public void addDriver(Driver driver) {

    }
}



