CREATE TABLE Books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    publication_year YEAR NOT NULL
    genre VARCHAR(255) NOT NULL,
    available TINYINT(1) NOT NULL DEFAULT 1,
    price DECIMAL(10,2) NOT NULL
);

INSERT INTO BOOKS (title, author, publisher, isbn, publication_year, genre, price)
    VALUES ('')