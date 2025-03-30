CREATE TABLE driver (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) UNIQUE NOT NULL,
    cab_details VARCHAR(255) NOT NULL
);

INSERT INTO driver (name, email, phone, cab_details) VALUES
('Mike Johnson', 'mike@example.com', '5551112222', 'Toyota Prius - XYZ123'),
('Emily Davis', 'emily@example.com', '5553334444', 'Honda Civic - ABC456');

SELECT d.name AS driver_name, d.cab_details,
       AVG(r.rating) AS avg_rating, COUNT(r.rating_id) AS total_reviews
FROM ratings r
JOIN drivers d ON r.driver_id = d.driver_id
WHERE r.driver_id = (SELECT driver_id FROM drivers WHERE email = 'mike@example.com')
GROUP BY d.name, d.cab_details;



