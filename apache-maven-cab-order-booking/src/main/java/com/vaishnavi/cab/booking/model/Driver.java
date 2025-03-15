package com.vaishnavi.cab.booking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;

    public Driver(int driverId, String name, String email, String phone, String cabDetails) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cabDetails = cabDetails;
    }

    public int getDriverId() {
        return 0;
    }
}
