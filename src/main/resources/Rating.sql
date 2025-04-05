CREATE TABLE rating (
    rating_id INT PRIMARY KEY AUTO_INCREMENT,
    ride_id INT,
    user_id INT,
    driver_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review TEXT,
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);
