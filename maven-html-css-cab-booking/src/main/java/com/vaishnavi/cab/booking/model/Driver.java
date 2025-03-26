package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Data

public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;

    public Driver(int driverId, String name, String email, String phone, String cabDetails) {
    }

    public Driver() {

    }


    public int getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCabDetails() {
        return cabDetails;
    }
}
