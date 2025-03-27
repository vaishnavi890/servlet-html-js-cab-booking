package com.vaishnavi.cab.booking.impl;

import com.vaishnavi.cab.booking.model.Driver;
import java.util.List;
import java.util.Optional;


public interface DriverImpl {
    void addDriver(Driver driver);
    Optional<Driver> getDriverById(int driverId);
    List<Driver> getAllDrivers();
    void updateDriver(Driver driver);
    void deleteDriver(int driverId);

    void saveDriver(Driver driver);
}
