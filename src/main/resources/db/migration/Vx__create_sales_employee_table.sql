CREATE TABLE `SalesEmployee` (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name VARCHAR(75) NOT NULL,
    BankAcctNum int NOT NULL,
    NINO CHAR(9) NOT NULL,
    Salary decimal(9,2) NOT NULL
    CommissionRate decimal (5,2)
);

