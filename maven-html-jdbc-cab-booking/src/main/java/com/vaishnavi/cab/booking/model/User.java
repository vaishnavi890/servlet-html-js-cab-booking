package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data


public class User {
    private int userId;
    private String name;
    private String email;
    private String phone;

    public User(int userId, String name, String email, String phone) {
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
}
