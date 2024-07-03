CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY
    title VARCHAR(255) NOT NULL
    author VARCHAR(255) NOT NULL
    publisher VARCHAR(255) NOT NULL
    isbn VARCHAR(255) NOT NULL
    publication_year YEAR NOT NULL
    genre VARCHAR(255) NOT NULL
    available TINYINT(1) NOT NULL DEFAULT 1
    price DECIMAL(10,2) NOT NULL
);

INSERT INTO books (title, author, publisher, isbn, publication_year, genre, available, price)
    VALUES(
    'The Shining',
    'Stephen King',
    'Doubleday',
    '978-0-385-12167-5',
    1977,
    'Horror',
    3,
    '20.00'
    );

INSERT INTO books (title, author, publisher, isbn, publication_year, genre, available, price)
    VALUES(
    'Salems Lot',
    'Stephen King',
    'Doubleday',
    '978-0-385-00751-1',
    1975,
    'Horror',
    5,
    '30.00'
    );

INSERT INTO books (title, author, publisher, isbn, publication_year, genre, available, price)
    VALUES(
    'Pet Sematary',
    'Stephen King',
    'Doubleday',
    '978-0-385-18244-7',
    1983,
    'Horror',
    1,
    '30.00'
    );

INSERT INTO books (title, author, publisher, isbn, publication_year, genre, available, price)
    VALUES(
    'In The Tall Grass',
    'Joe Hill',
    'Simon & Schuster',
    '978-1-732-297045-8',
    2012,
    'Horror',
    8,
    '20.00'
    );

CREATE TABLE members(
    id INT AUTO_INCREMENT PRIMARY KEY
    first_name VARCHAR(255) NOT NULL
    last_name VARCHAR(255) NOT NULL
    address VARCHAR(255) NOT NULL
    phone VARCHAR(255) NOT NULL
    email VARCHAR(255) NOT NULL
    register_date DATE NOT NULL
);


INSERT INTO members(first_name, last_name, address, phone, email, register_date)
    VALUES(
        'Nathan',
        'Totten',
        '4-6 Upper Crescent, Belfast',
        '012345678921',
        'nathan.totten@kainos.com',
        '2024-06-26'
    );

INSERT INTO members(first_name, last_name, address, phone, email, register_date)
    VALUES(
        'Jamie',
        'Mcconnell',
        '4-6 Upper Crescent, Belfast',
        '012345678921',
        'jamie.mcconnell@kainos.com',
        '2024-06-26'
    );

INSERT INTO members(first_name, last_name, address, phone, email, register_date)
    VALUES(
        'Hannah',
        'Morgan',
        '4-6 Upper Crescent, Belfast',
        '012345678921',
        'hannah.morgan@kainos.com',
        '2024-06-26'
    );

INSERT INTO members(first_name, last_name, address, phone, email, register_date)
    VALUES(
        'Joel',
        'Anderson',
        '4-6 Upper Crescent, Belfast',
        '012345678921',
        'joel.anderson@kainos.com',
        '2024-06-26'
    );

INSERT INTO members(first_name, last_name, address, phone, email, register_date)
    VALUES(
        'Jack',
        'Pollins',
        '4-6 Upper Crescent, Belfast',
        '012345678921',
        'jack.pollins@kainos.com',
        '2024-06-26'
    );

INSERT INTO members(first_name, last_name, address, phone, email, register_date)
    VALUES(
        '',
        '',
        '4-6 Upper Crescent, Belfast',
        '012345678921',
        '@kainos.com',
        '2024-06-26'
    );