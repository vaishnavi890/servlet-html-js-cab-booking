CREATE DATABASE cab_management;
USE cab_management;

-- Users Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL
);

-- Insert User
INSERT INTO users (name, email, phone) VALUES (?, ?, ?);

-- Update User
UPDATE users SET name = ?, email = ?, phone = ? WHERE user_id = ?;

-- Delete User
DELETE FROM users WHERE user_id = ?;

-- Get User by ID
SELECT * FROM users WHERE user_id = ?;

-- Get All Users
SELECT * FROM users;
