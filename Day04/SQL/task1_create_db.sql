-- SQL for TASK 1
CREATE DATABASE IF NOT EXISTS day04_task1;
USE day04_task1;
CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(255),
  email VARCHAR(255) UNIQUE,
  username VARCHAR(255) UNIQUE,
  password VARCHAR(255)
);
INSERT INTO users (full_name, email, username, password) VALUES ('Test User','test@example.com','testuser','Test@1234');
