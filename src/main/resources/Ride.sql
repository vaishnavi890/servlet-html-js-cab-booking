CREATE TABLE rides (
    ride_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    driver_id INT,
    pickup_location VARCHAR(150),
    dropoff_location VARCHAR(150),
    fare DOUBLE,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);
