package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Data

public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;

    public Driver(int driverId, String name, String email, String phone, String cabDetails) {
    }
}
