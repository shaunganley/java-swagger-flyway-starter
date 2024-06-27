

CREATE TABLE Employee(
    EmployeeID smallint PRIMARY KEY AUTO_INCREMENT not NULL,
    FName varchar(30),
    SName varchar(60),
    Salary Decimal(11,2),
    BankNumber tinyint,
    NiNumber char(9)
);

CREATE table EmployeeSales(
    EmployeeID smallint,
    Commission smallint,
    foreign KEY(EmployeeID) references Employee(EmployeeID)
);

insert into Employee (FName,SName,Salary,BankNumber,NiNumber)
values('User1Fname','User1SName',1000.00,12345678,'AB123456C'),
values('User2Fname','User2SName',10000.00,87654321,'CB123456A');

insert into EmployeeSales (EmployeeID,Commission)
values(1,20);