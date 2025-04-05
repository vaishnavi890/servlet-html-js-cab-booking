package com.vaishnavi.servlet.cab.booking.controller;

import com.vaishnavi.servlet.cab.booking.model.Driver;
import com.vaishnavi.servlet.cab.booking.service.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class DriverController extends HttpServlet {

        DriverService driverService = new DriverService();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("--- Inside doGet: Fetching all drivers ---");

            try {
                List<Driver> driverList = driverService.getAllDrivers();
                request.setAttribute("driverList", driverList);
                request.getRequestDispatcher("/display-drivers.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("--- Inside service() ---");
            super.service(request, response); // Calls doGet/doPost depending on HTTP method
        }
}




