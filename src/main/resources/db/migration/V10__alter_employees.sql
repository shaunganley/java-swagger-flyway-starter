ALTER TABLE Client
    DROP FOREIGN KEY `FK_SalesEmployeeID`;

DROP TABLE SalesEmployee;


CREATE TABLE SalesEmployee (
    id int AUTO_INCREMENT PRIMARY KEY,
    EmployeeID int NOT NULL,
    commission_rate decimal(5,2) not null default 0
);


ALTER TABLE SalesEmployee
    ADD CONSTRAINT `FK_EmployeeID` FOREIGN KEY (EmployeeID)
    REFERENCES DeliveryEmployee(id);