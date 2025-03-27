CREATE TABLE drivers (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    cab_details VARCHAR(255) NOT NULL
);

-- Insert Driver
INSERT INTO drivers (name, email, phone, cab_details) VALUES (?, ?, ?, ?);

-- Update Driver
UPDATE drivers SET name = ?, email = ?, phone = ?, cab_details = ? WHERE driver_id = ?;

-- Delete Driver
DELETE FROM drivers WHERE driver_id = ?;

-- Get Driver by ID
SELECT * FROM drivers WHERE driver_id = ?;

-- Get All Drivers
SELECT * FROM drivers;
