CREATE TABLE rides (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT,
    pickup_location VARCHAR(255) NOT NULL,
    dropoff_location VARCHAR(255) NOT NULL,
    fare DOUBLE NOT NULL,
    status ENUM('Booked', 'Completed', 'Cancelled') DEFAULT 'Booked',
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);

-- Book a Ride
INSERT INTO rides (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, 'Booked');

-- Update Ride Status
UPDATE rides SET status = ? WHERE ride_id = ?;

-- Delete Ride
DELETE FROM rides WHERE ride_id = ?;

-- Get Ride by ID
SELECT * FROM rides WHERE ride_id = ?;

-- Get All Rides
SELECT * FROM rides;
