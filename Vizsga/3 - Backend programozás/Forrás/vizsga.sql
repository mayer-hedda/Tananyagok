CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


DELIMITER //
CREATE PROCEDURE CreateUser (
    IN p_username VARCHAR(50),
    IN p_email VARCHAR(100),
    IN p_password VARCHAR(255)
)
BEGIN
    INSERT INTO users (username, email, password) VALUES (p_username, p_email, p_password);
END;//

DELIMITER //
CREATE PROCEDURE GetUser (
    IN p_user_id INT
)
BEGIN
    SELECT * FROM users WHERE id = p_user_id;
END;//


DELIMITER //
CREATE PROCEDURE UpdateUser (
    IN p_user_id INT,
    IN p_username VARCHAR(50),
    IN p_email VARCHAR(100),
    IN p_password VARCHAR(255)
)
BEGIN
    UPDATE users
    SET username = p_username,
        email = p_email,
        password = p_password,
        updated_at = CURRENT_TIMESTAMP
    WHERE id = p_user_id;
END;//


DELIMITER //
CREATE PROCEDURE DeleteUser (
    IN p_user_id INT
)
BEGIN
    DELETE FROM users WHERE id = p_user_id;
END;//


INSERT INTO users (username, email, password) VALUES
('john_doe', 'john.doe@example.com', 'apple123'),
('jane_smith', 'jane.smith@example.com', 'password123'),
('mike_jones', 'mike.jones@example.com', 'letmein'),
('emily_brown', 'emily.brown@example.com', 'qwerty'),
('chris_taylor', 'chris.taylor@example.com', '123456'),
('sarah_miller', 'sarah.miller@example.com', 'football'),
('david_clark', 'david.clark@example.com', 'baseball'),
('lisa_white', 'lisa.white@example.com', 'monkey'),
('kevin_hall', 'kevin.hall@example.com', 'sunshine'),
('rachel_wilson', 'rachel.wilson@example.com', 'password');
