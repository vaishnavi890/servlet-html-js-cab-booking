CREATE TABLE payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    amount DOUBLE NOT NULL,
    payment_method ENUM('Cash', 'Card') NOT NULL,
    status ENUM('Pending', 'Completed') DEFAULT 'Pending',
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Insert Payment
INSERT INTO payments (ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, 'Completed');

-- Update Payment Status
UPDATE payments SET status = ? WHERE payment_id = ?;

-- Delete Payment
DELETE FROM payments WHERE payment_id = ?;

-- Get Payment by ID
SELECT * FROM payments WHERE payment_id = ?;

-- Get All Payments
SELECT * FROM payments;
