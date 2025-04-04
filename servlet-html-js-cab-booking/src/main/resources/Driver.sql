CREATE TABLE driver (
    driver_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    cab_details VARCHAR(200)
);
