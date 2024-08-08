CREATE TABLE delivery (
                       id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       employeeID int,
                       CONSTRAINT fk_employeeDelivery FOREIGN KEY (employeeID) REFERENCES employee(id)
);