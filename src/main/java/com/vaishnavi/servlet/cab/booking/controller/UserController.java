package com.vaishnavi.servlet.cab.booking.controller;

import com.vaishnavi.servlet.cab.booking.model.User;
import com.vaishnavi.servlet.cab.booking.service.UserService;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class UserController extends HttpServlet {

    private final UserService userService = new UserService();

    // ================================
    // service() → Routing logic
    // ================================
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getMethod();
        System.out.println(">> Inside service() - Method: " + method);

        if ("GET".equalsIgnoreCase(method)) {
            doGet(request, response);
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost(request, response);
        } else if ("PUT".equalsIgnoreCase(method)) {
            doPut(request, response);
        } else if ("DELETE".equalsIgnoreCase(method)) {
            doDelete(request, response);
        } else {
            response.getWriter().println("Unsupported Method!");
        }
    }

    // ================================
    // doGet() → Retrieve all users
    // ================================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(">> Inside doGet() - Retrieve Users");
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            List<User> users = userService.getAllUsers();
            out.println("<h2>User List</h2>");
            users.stream().forEach(user -> out.println("<p>" + user + "</p>"));
        }
    }

    // ================================
    // doPost() → Insert user
    // ================================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(">> Inside doPost() - Add User");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User(0, name, email, phone); // id is auto-generated
        userService.addUser(user);
        response.getWriter().println("<p>User added successfully!</p>");
    }

    // ================================
    // doPut() → Update user
    // ================================
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(">> Inside doPut() - Update User");

        try (BufferedReader reader = request.getReader()) {
            String body = reader.lines().collect(Collectors.joining());
            String[] data = body.split("&");

            int userId = Integer.parseInt(data[0].split("=")[1]);
            String name = data[1].split("=")[1];
            String email = data[2].split("=")[1];
            String phone = data[3].split("=")[1];

            User user = new User(userId, name, email, phone);
            userService.updateUser(user);
            response.getWriter().println("<p>User updated successfully!</p>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error updating user</p>");
        }
    }

    // ================================
    // doDelete() → Delete user
    // ================================
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(">> Inside doDelete() - Delete User");

        try {
            int userId = Integer.parseInt(request.getParameter("user_id"));
            userService.deleteUser(userId);
            response.getWriter().println("<p>User deleted successfully!</p>");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error deleting user</p>");
        }
    }

    // ================================
    // destroy() → Resource Cleanup
    // ================================
    @Override
    public void destroy() {
        System.out.println(">> Servlet destroyed");
    }
}



