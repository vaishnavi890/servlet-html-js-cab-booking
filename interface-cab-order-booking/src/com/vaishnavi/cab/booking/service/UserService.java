package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;

public interface UserService extends BaseService<User>{
    void userOperations();

    User getUserByEmail(String email);
}
