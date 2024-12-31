package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.UserService;
import com.vaishnavi.cab.booking.service.DriverService;

public class CabOrderController {
    private UserService userService = new UserService();
    private DriverService driverService = new DriverService();

    public void run() {
        User user1 = new User("U1", "John Doe", "john@example.com", "1234567890");
        User user2 = new User("U2", "Jane Smith", "jane@example.com", "0987654321");
        userService.registerUser(user1);
        userService.registerUser(user2);

        Driver driver1 = new Driver("D1", "Mike Driver", "mike@example.com", "1231231234", "Sedan");
        Driver driver2 = new Driver("D2", "Sara Wheels", "sara@example.com", "9876543210", "SUV");
        driverService.registerDriver(driver1);
        driverService.registerDriver(driver2);

        userService.displayUsers();
        driverService.displayDrivers();
    }
}

