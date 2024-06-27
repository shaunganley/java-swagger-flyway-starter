
CREATE TABLE `Employee` (
	`Employee_ID` int auto_increment NOT NULL PRIMARY KEY,
    `Name` varchar(100) NOT NULL,
    `Salary` decimal(11,2) NOT NULL,
    `BankNo` varchar(9) NOT NULL,
    `CommissionRate` decimal(11,2),
    `Role_ID` int NOT NULL
    );
