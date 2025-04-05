package com.vaishnavi.servlet.cab.booking.controller;

import com.vaishnavi.servlet.cab.booking.model.User;
import com.vaishnavi.servlet.cab.booking.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        request.setAttribute("userList", users);
        request.getRequestDispatcher("/display-users.jsp").forward(request, response);
    }
}


