CREATE DATABASE IF NOT EXISTS lostlink_db;
USE lostlink_db;

CREATE TABLE IF NOT EXISTS items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    description TEXT,
    location VARCHAR(100) NOT NULL,
    item_date DATE NOT NULL,
    type VARCHAR(20) NOT NULL, -- 'Lost' or 'Found'
    status VARCHAR(20) DEFAULT 'Active' -- 'Active', 'Claimed', or 'Resolved'
);