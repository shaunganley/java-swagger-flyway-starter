

CREATE TABLE Employee(
    EmployeeID smallint PRIMARY KEY AUTO_INCREMENT not NULL,
    FName varchar(30),
    SName varchar(60),
    Salary Decimal(11,2),
    BankNumber tinyint,
    NiNumber char(8)
);

CREATE table EmployeeSales(
    EmployeeID smallint,
    Commission smallint,
    foreign KEY(EmployeeID) references Employee(EmployeeID)
);