-- Drop the existing database if it exists
DROP DATABASE IF EXISTS cab_order_management;

-- Create the database
CREATE DATABASE cab_order_management;

-- Use the newly created database
USE cab_order_management;

-- ============================
-- Users Table
-- ============================
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL
);

-- ============================
-- Drivers Table
-- ============================
CREATE TABLE drivers (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    cab_details VARCHAR(100) NOT NULL
);

-- ============================
-- Rides Table
-- ============================
CREATE TABLE rides (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT,
    pickup_location VARCHAR(100) NOT NULL,
    dropoff_location VARCHAR(100) NOT NULL,
    fare DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);

-- ============================
-- Payments Table
-- ============================
CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- ============================
-- Ratings Table
-- ============================
CREATE TABLE ratings (
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    driver_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review TEXT,
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);

-- ===================================
-- INSERT: Add Records to Tables
-- ===================================
-- Users
INSERT INTO users (name, email, phone)
VALUES
('John Doe', 'john@example.com', '1234567890'),
('Alice Johnson', 'alice@example.com', '9876543210');

-- Drivers
INSERT INTO drivers (name, email, phone, cab_details)
VALUES
('Alex Smith', 'alex@cab.com', '1122334455', 'Toyota Prius - ABC123'),
('Bob Taylor', 'bob@cab.com', '6677889900', 'Honda Civic - XYZ789');

-- Rides
INSERT INTO rides (user_id, driver_id, pickup_location, dropoff_location, fare, status)
VALUES
(1, 1, 'Downtown', 'Airport', 25.50, 'Completed'),
(2, 2, 'Mall', 'Station', 15.75, 'Ongoing');

-- Payments
INSERT INTO payments (ride_id, user_id, amount, payment_method, status)
VALUES
(1, 1, 25.50, 'Credit Card', 'Successful'),
(2, 2, 15.75, 'Cash', 'Pending');

-- Ratings
INSERT INTO ratings (ride_id, user_id, driver_id, rating, review)
VALUES
(1, 1, 1, 5, 'Great service!'),
(2, 2, 2, 4, 'Good ride, but a bit late.');

-- ===================================
-- UPDATE: Modify Existing Records
-- ===================================
-- Update a user's phone number
UPDATE users
SET phone = '9998887776'
WHERE name = 'John Doe';

-- Update ride status
UPDATE rides
SET status = 'Completed'
WHERE ride_id = 2;

-- Update payment status
UPDATE payments
SET status = 'Successful'
WHERE payment_id = 2;

-- Update driver cab details
UPDATE drivers
SET cab_details = 'Honda Accord - LMN456'
WHERE driver_id = 2;

-- Update a rating
UPDATE ratings
SET review = 'Amazing ride, very comfortable!'
WHERE rating_id = 1;

-- ===================================
-- DELETE: Remove Records
-- ===================================
-- Delete a user
DELETE FROM users
WHERE email = 'alice@example.com';

-- Delete a ride
DELETE FROM rides
WHERE pickup_location = 'Mall';

-- Delete a payment record
DELETE FROM payments
WHERE payment_id = 2;

-- Delete a driver
DELETE FROM drivers
WHERE driver_id = 2;

-- Delete a rating
DELETE FROM ratings
WHERE rating_id = 2;

-- ===================================
-- WHERE: Filter and Fetch Data
-- ===================================
-- Select all completed rides
SELECT * FROM rides
WHERE status = 'Completed';

-- Fetch all successful payments
SELECT * FROM payments
WHERE status = 'Successful';

-- Get all drivers with "Toyota" in cab details
SELECT * FROM drivers
WHERE cab_details LIKE '%Toyota%';

-- Get all users with phone numbers starting with '999'
SELECT * FROM users
WHERE phone LIKE '999%';

-- ===================================
-- Aggregate Functions and Grouping
-- ===================================
-- Count total rides
SELECT COUNT(*) AS total_rides
FROM rides;

-- Average fare of completed rides
SELECT AVG(fare) AS avg_fare
FROM rides
WHERE status = 'Completed';

-- Total earnings from successful payments
SELECT SUM(amount) AS total_earnings
FROM payments
WHERE status = 'Successful';

-- Average rating per driver
SELECT driver_id, AVG(rating) AS avg_rating
FROM ratings
GROUP BY driver_id;

-- ===================================
-- JOIN Operations
-- ===================================
-- Join users and rides to get user names with ride details
SELECT u.name, r.pickup_location, r.dropoff_location, r.fare
FROM users u
JOIN rides r ON u.user_id = r.user_id;

-- Join rides and payments to get ride fares and payment methods
SELECT r.ride_id, r.fare, p.payment_method
FROM rides r
JOIN payments p ON r.ride_id = p.ride_id;

-- Join drivers and ratings to get driver names and average ratings
SELECT d.name, AVG(rt.rating) AS avg_rating
FROM drivers d
JOIN ratings rt ON d.driver_id = rt.driver_id
GROUP BY d.name;

-- ===================================
-- Clean Up (Drop All Tables)
-- ===================================
-- DROP TABLE IF EXISTS ratings, payments, rides, drivers, users;
