package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;

public interface DriverService extends BaseService<Driver> {
    void driverOperations();

    Driver getDriverByCabDetails(String cabDetails);
}
