package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NonNull
@NoArgsConstructor
@ToString
@Data

public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;

    // Constructor
    public Driver(int driverId, String name, String email, String phone, String cabDetails) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cabDetails = cabDetails;
    }

    public String getName() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getPhone() {
        return "";
    }

    public String getCabDetails() {
        return "";
    }

    public void setDriverId(int anInt) {
    }

    public Integer getDriverId() {
        return 0;
    }
}
