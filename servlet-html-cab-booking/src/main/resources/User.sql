CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL
);

INSERT INTO user (name, email, phone) VALUES
('John Doe', 'john@example.com', '1234567890'),
('Alice Smith', 'alice@example.com', '9876543210');

SELECT r.ride_id, r.pickup_location, r.dropoff_location, r.fare, r.status, r.ride_date,
       d.name AS driver_name, d.cab_details
FROM rides r
JOIN drivers d ON r.driver_id = d.driver_id
WHERE r.user_id = (SELECT user_id FROM users WHERE email = 'john@example.com')
ORDER BY r.ride_date DESC;

