package com.vaishnavi.servlet.cab.booking.controller;

import com.vaishnavi.servlet.cab.booking.model.Driver;
import com.vaishnavi.servlet.cab.booking.service.DriverService;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;

public class DriverController extends HttpServlet {

    private final DriverService driverService = new DriverService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")) {
            doGet(req, resp);
        } else if (method.equalsIgnoreCase("POST")) {
            doPost(req, resp);
        } else if (method.equalsIgnoreCase("DELETE")) {
            doDelete(req, resp);
        } else {
            resp.getWriter().println("Unsupported HTTP method.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Driver> drivers = driverService.getAllDrivers();
        PrintWriter out = resp.getWriter();
        drivers.forEach(driver -> out.println("<p>" + driver + "</p>"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String cabDetails = req.getParameter("cabDetails");

        Driver driver = new Driver(0, name, email, phone, cabDetails);
        boolean added = driverService.addDriver(driver);
        resp.getWriter().println(added ? "Driver Added" : "Failed to add driver");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int driverId = Integer.parseInt(req.getParameter("driver_id"));
        boolean deleted = driverService.deleteDriver(driverId);
        resp.getWriter().println(deleted ? "Driver Deleted" : "Deletion failed");
    }

    @Override
    public void destroy() {
        System.out.println("DriverController destroyed.");
    }
}




