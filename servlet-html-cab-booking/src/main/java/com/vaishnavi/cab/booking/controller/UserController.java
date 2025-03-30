package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserController extends HttpServlet {

    private static final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doPost() method: User Registration =========");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User(0, name, email, phone);
        boolean isRegistered = userService.registerUser(user);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + (isRegistered ? "User Registered Successfully!" : "User Registration Failed!") + "</h1>");
        writer.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doGet() method: Fetch Users =========");

        List<User> users = userService.getAllUsers();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body><h2>Users List</h2><ul>");
        for (User user : users) {
            writer.println("<li>" + user.getName() + " - " + user.getEmail() + "</li>");
        }
        writer.println("</ul></body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("========= Inside the destroy() method: UserController =========");
    }
}

