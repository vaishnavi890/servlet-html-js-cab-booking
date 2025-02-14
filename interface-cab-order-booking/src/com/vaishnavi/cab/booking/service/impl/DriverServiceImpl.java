package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.service.DriverService;
import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.exception.DriverException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverServiceImpl implements DriverService {
    private List<Driver> drivers = new ArrayList<>();

    @Override
    public void add(Driver driver) throws DriverException {
        if (driver == null || driver.getName().isEmpty()) {
            throw new DriverException("Invalid driver details!");
        }
        drivers.add(driver);
        System.out.println("Driver added successfully: " + driver.getName());
    }

    @Override
    public Driver getById(int id) {
        return null;
    }

    @Override
    public List<Driver> getAll() throws DriverException {
        if (drivers.isEmpty()) {
            throw new DriverException("No drivers found.");
        }
        return drivers;
    }
    @Override
    public void driverOperations() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Register Driver");
            System.out.println("2. Display Drivers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Driver ID: ");
                    int driverId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    try {
                        add(new Driver(driverId, name, email, phone));
                    } catch (DriverException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        getAll().forEach(driver -> System.out.println(driver.getName()));
                    } catch (DriverException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
            }
        } while (choice != 3);
    }

    @Override
    public Driver getDriverByCabDetails(String cabDetails) {
        return null;
    }
}
