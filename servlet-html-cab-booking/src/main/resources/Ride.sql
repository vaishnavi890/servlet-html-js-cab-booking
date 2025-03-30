CREATE TABLE ride (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    driver_id INT NOT NULL,
    pickup_location VARCHAR(255) NOT NULL,
    dropoff_location VARCHAR(255) NOT NULL,
    fare DECIMAL(10,2) NOT NULL,
    status ENUM('Booked', 'Completed', 'Cancelled') DEFAULT 'Booked',
    ride_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id) ON DELETE CASCADE
);

INSERT INTO ride (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES
(1, 1, 'Downtown', 'Airport', 25.50, 'Booked'),
(2, 2, 'Mall', 'Hotel', 15.75, 'Completed');

SELECT r.ride_id, r.pickup_location, r.dropoff_location, r.fare, r.status, r.ride_date,
       u.name AS passenger_name, u.phone AS passenger_contact
FROM rides r
JOIN users u ON r.user_id = u.user_id
WHERE r.driver_id = (SELECT driver_id FROM drivers WHERE email = 'mike@example.com')
ORDER BY r.ride_date DESC;

