package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DriverController extends HttpServlet {

    private static final DriverService driverService = new DriverService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doPost() method: Driver Registration =========");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String cabDetails = request.getParameter("cabDetails");

        Driver driver = new Driver(0, name, email, phone, cabDetails);
        boolean isRegistered = driverService.registerDriver(driver);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + (isRegistered ? "Driver Registered Successfully!" : "Driver Registration Failed!") + "</h1>");
        writer.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========= Inside the doGet() method: Fetch Drivers =========");

        List<Driver> drivers = driverService.getAllDrivers();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body><h2>Drivers List</h2><ul>");
        for (Driver driver : drivers) {
            writer.println("<li>" + driver.getName() + " - " + driver.getCabDetails() + "</li>");
        }
        writer.println("</ul></body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("========= Inside the destroy() method: DriverController =========");
    }
}


