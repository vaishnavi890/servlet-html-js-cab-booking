package com.vaishnavi.cab.booking.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Data

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

    public String getName() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getPhone() {
        return "";
    }

    public void setUserId(int anInt) {
    }

    public Integer getUserId() {
        return 0;
    }
}
