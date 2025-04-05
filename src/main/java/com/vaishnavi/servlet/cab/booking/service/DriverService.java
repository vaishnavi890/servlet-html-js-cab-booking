package com.vaishnavi.servlet.cab.booking.service;

import com.vaishnavi.servlet.cab.booking.model.Driver;
import com.vaishnavi.servlet.cab.booking.repository.DriverRepository;

import java.util.List;

public class DriverService {
    DriverRepository repo = new DriverRepository();

    public List<Driver> getAllDrivers() throws Exception {
        return repo.fetchAllDrivers();
    }
}


