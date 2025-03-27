package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import java.util.List;
import java.util.Optional;

public interface DriverServiceInterface {
    void registerDriver(Driver driver);
    List<Driver> getAllDrivers();
    Optional<Driver> getDriverById(int driverId);
    void updateDriver(int driverId, String name, String email, String phone, String cabDetails);
    void deleteDriver(int driverId);

    void addDriver(Driver driver);
}



