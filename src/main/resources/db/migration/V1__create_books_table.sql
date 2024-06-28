CREATE TABLE `Books`(
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    publication_year YEAR NOT NULL,
    genre VARCHAR(255) NOT NULL,
    available TINYINT(1) NOT NULL DEFAULT 1,
    price DECIMAL(10,2) NOT NULL
);

INSERT INTO Books (title, author, publisher, isbn, publication_year, genre, available, price) VALUES
('To Kill a Mockingbird', 'Harper Lee', 'J.B. Lippincott & Co.', '9780061120084', 1960, 'Fiction', 1, 18.99),
('1984', 'George Orwell', 'Secker & Warburg', '9780451524935', 1949, 'Dystopian', 1, 15.99),
('The Great Gatsby', 'F. Scott Fitzgerald', 'Charles Scribner\'s Sons', '9780743273565', 1925, 'Classic', 1, 10.99),
('The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', '9780316769488', 1951, 'Fiction', 1, 13.99),
('Pride and Prejudice', 'Jane Austen', 'T. Egerton', '9781503290563', 1813, 'Romance', 1, 9.99),
('The Hobbit', 'J.R.R. Tolkien', 'George Allen & Unwin', '9780547928227', 1937, 'Fantasy', 1, 14.99),
('Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', 'Bloomsbury', '9780439708180', 1997, 'Fantasy', 1, 12.99),
('The Lord of the Rings', 'J.R.R. Tolkien', 'George Allen & Unwin', '9780544003415', 1954, 'Fantasy', 1, 29.99),
('The Chronicles of Narnia', 'C.S. Lewis', 'Geoffrey Bles', '9780066238500', 1950, 'Fantasy', 1, 19.99),
('The Da Vinci Code', 'Dan Brown', 'Doubleday', '9780385504201', 2003, 'Thriller', 1, 16.99);
