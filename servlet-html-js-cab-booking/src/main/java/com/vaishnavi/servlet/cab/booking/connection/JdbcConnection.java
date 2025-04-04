package com.vaishnavi.servlet.cab.booking.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/cabdb"; // Update with your DB name
    private static final String USERNAME = "root"; // Change as needed
    private static final String PASSWORD = "password"; // Change as needed

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        int retry = 0;

        do {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("DB connection failed, retrying... Attempt: " + (++retry));
                try {
                    Thread.sleep(1000); // Wait before retry
                } catch (InterruptedException ignored) {}
            }
        } while (connection == null && retry < 3);

        if (connection == null) {
            throw new SQLException("Unable to establish database connection after 3 attempts.");
        }

        return connection;
    }
}



