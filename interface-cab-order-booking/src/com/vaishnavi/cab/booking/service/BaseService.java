package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.exception.DriverException;
import com.vaishnavi.cab.booking.exception.UserException;

import java.util.List;

public interface BaseService<T> {
    void add(T t) throws UserException, DriverException;
    T getById(int id);
    List<T> getAll() throws DriverException, UserException;
}

