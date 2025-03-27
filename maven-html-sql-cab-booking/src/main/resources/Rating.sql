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

-- Insert Rating
INSERT INTO ratings (ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?);

-- Update Rating
UPDATE ratings SET rating = ?, review = ? WHERE rating_id = ?;

-- Delete Rating
DELETE FROM ratings WHERE rating_id = ?;

-- Get Rating by ID
SELECT * FROM ratings WHERE rating_id = ?;

-- Get All Ratings
SELECT * FROM ratings;
