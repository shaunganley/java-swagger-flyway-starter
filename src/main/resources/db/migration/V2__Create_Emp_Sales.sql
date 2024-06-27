
CREATE TABLE Employee(
    EmployeeID smallint PRIMARY KEY AUTO_INCREMENT not NULL,
    FName varchar(30),
    SName varchar(60),
    BankNumber tinyint,
    NiNumber char(8)
);

CREATE table EmployeeSales(
    EmployeeID smallint,
    Commission smallint,
    foreign KEY(EmployeeID) references Employee(EmployeeID)
);