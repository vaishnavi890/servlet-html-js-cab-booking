package com.vaishnavi.servlet.cab.booking.model;

public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;

    public Driver() {}

    public Driver(int driverId, String name, String email, String phone, String cabDetails) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cabDetails = cabDetails;
    }

    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCabDetails() { return cabDetails; }
    public void setCabDetails(String cabDetails) { this.cabDetails = cabDetails; }
}

