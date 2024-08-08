CREATE TABLE SalesEmployee(
    SalesID int PRIMARY KEY AUTO_INCREMENT,
    EmployeeID int not null,
    Commission decimal(5,2),

    FOREIGN KEY(EmployeeID) REFERENCES Employee(EmployeeID)
 );