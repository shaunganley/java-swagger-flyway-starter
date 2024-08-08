CREATE TABLE sales (
                          id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                          commissionRate decimal(2,2) NOT NULL,
                          employeeID int,
                          CONSTRAINT fk_employeeSales FOREIGN KEY (employeeID) REFERENCES employee(id)
);