CREATE TABLE payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT NOT NULL,
    user_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_method ENUM('Cash', 'Card', 'UPI') NOT NULL,
    status ENUM('Completed', 'Pending', 'Failed') DEFAULT 'Pending',
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

INSERT INTO payment (ride_id, user_id, amount, payment_method, status) VALUES
(1, 1, 25.50, 'Card', 'Completed'),
(2, 2, 15.75, 'Cash', 'Completed');

SELECT p.payment_id, p.amount, p.payment_method, p.status, p.payment_date,
       r.pickup_location, r.dropoff_location, d.name AS driver_name
FROM payments p
JOIN rides r ON p.ride_id = r.ride_id
JOIN drivers d ON r.driver_id = d.driver_id
WHERE p.user_id = (SELECT user_id FROM users WHERE email = 'alice@example.com')
ORDER BY p.payment_date DESC;

