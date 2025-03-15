create database IF NOT EXISTS stepupdb;
USE stepupdb;

CREATE TABLE IF NOT EXISTS Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15)
);

INSERT INTO Users (name, email, phone) VALUES
('John Doe', 'john@example.com', '1234567890'),
('Alice Smith', 'alice@example.com', '9876543210');

SELECT * FROM Users;

CREATE TABLE IF NOT EXISTS Drivers (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    cab_details VARCHAR(255)
);

INSERT INTO Drivers (name, email, phone, cab_details) VALUES
('Mike Johnson', 'mike@cab.com', '1112223333', 'Sedan - ABC123'),
('Sarah Lee', 'sarah@cab.com', '4445556666', 'SUV - XYZ789');


SELECT * FROM Drivers;


CREATE TABLE IF NOT EXISTS Rides (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT,
    pickup_location VARCHAR(255),
    dropoff_location VARCHAR(255),
    fare DECIMAL(10, 2),
    status VARCHAR(50)
);


INSERT INTO Rides (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES
(1, 1, 'Central Park', 'Times Square', 15.50, 'Completed'),
(2, 2, 'Airport', 'Hotel', 30.75, 'Ongoing');


SELECT * FROM Rides;


CREATE TABLE IF NOT EXISTS Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    amount DECIMAL(10, 2),
    payment_method VARCHAR(50),
    status VARCHAR(50)
);


INSERT INTO Payments (ride_id, user_id, amount, payment_method, status) VALUES
(1, 1, 15.50, 'Credit Card', 'Success'),
(2, 2, 30.75, 'Cash', 'Pending');


SELECT * FROM Payments;


CREATE TABLE IF NOT EXISTS Ratings (
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    driver_id INT,
    rating INT,
    review TEXT
);


INSERT INTO Ratings (ride_id, user_id, driver_id, rating, review) VALUES
(1, 1, 1, 5, 'Great ride! Comfortable and clean car.'),
(2, 2, 2, 4, 'Good service, but a bit late.');


SELECT * FROM Ratings;