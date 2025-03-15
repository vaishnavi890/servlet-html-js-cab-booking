package com.vaishnavi.cab.booking.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Data

public class User {
    private int userId;
    private String name;
    private String email;
    private String phone;

    public User(int userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getUserId() {
        return 0;
    }
}

