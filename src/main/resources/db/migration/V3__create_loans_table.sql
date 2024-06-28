CREATE TABLE `Loans` (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT NOT NULL,
    book_id INT NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (member_id) REFERENCES Members(member_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

INSERT INTO Loans (member_id, book_id, loan_date, return_date) VALUES
(1, 1, '2024-06-28', NULL),
(2, 2, '2024-06-28', NULL),
(3, 3, '2024-06-28', NULL);


