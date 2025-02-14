package com.vaishnavi.cab.booking.model;

public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;

    public Driver(int driverId, String name, String email, String phone) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cabDetails = cabDetails;
    }

    public int getDriverId() { return driverId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCabDetails() { return cabDetails; }
}

