CREATE TABLE salesEmployee (
    employeeID int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    firstName varchar(200) NOT NULL,
    lastName varchar(200) NOT NULL,
    salary decimal NOT NULL,
    bankAccountNumber int(50) NOT NULL,
    nationalInsuranceNumber int(20) NOT NULL,
    commissionRate int(30) NOT NULL
);