
-- 1. users table
CREATE TABLE users (
    userspk_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('CUSTOMER', 'ADMIN') DEFAULT 'CUSTOMER',
    creation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. categories table
CREATE TABLE categories (
    categoriespk_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

-- 3. books table
CREATE TABLE books (
    bookpk_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    price Double NOT NULL,
    stock INT NOT NULL,
    categoryfk_id BIGINT,
    userfk_id BIGINT,  -- user who added/wrote the book
    creation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (categoryfk_id) REFERENCES categories(categoriespk_id),
    FOREIGN KEY (userfk_id) REFERENCES users(userspk_id)
);


