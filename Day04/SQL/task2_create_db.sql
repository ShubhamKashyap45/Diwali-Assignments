-- SQL for TASK 2 - Books CRUD
CREATE DATABASE IF NOT EXISTS day04_books;
USE day04_books;
CREATE TABLE IF NOT EXISTS books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  author VARCHAR(255),
  price DOUBLE
);
INSERT INTO books (title, author, price) VALUES ('Clean Code','Robert Martin',399.0);
