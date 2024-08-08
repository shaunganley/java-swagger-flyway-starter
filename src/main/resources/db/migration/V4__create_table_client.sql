CREATE TABLE client
(
    id      INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    salesID int,
    CONSTRAINT fk_sales FOREIGN KEY (salesID) REFERENCES sales (id)
);