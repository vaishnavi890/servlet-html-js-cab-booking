CREATE TABLE rating (
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT NOT NULL,
    user_id INT NOT NULL,
    driver_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review TEXT,
    rating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id) ON DELETE CASCADE
);

INSERT INTO rating (ride_id, user_id, driver_id, rating, review) VALUES
(2, 2, 2, 5, 'Excellent service!'),
(1, 1, 1, 4, 'Good ride but took a bit longer.');

