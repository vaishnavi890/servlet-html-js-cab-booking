CREATE TABLE payment (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    ride_id INT,
    user_id INT,
    amount DOUBLE,
    payment_method VARCHAR(50),
    status VARCHAR(50),
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
