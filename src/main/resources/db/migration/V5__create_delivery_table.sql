CREATE TABLE deliveryEmployee (
    employeeID int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    fname varchar(200) NOT NULL,
    lname varchar(200) NOT NULL,
    salary decimal(10,2) NOT NULL,
    bankAccountNum varchar(20) NOT NULL,
    nationalInsureNum varchar(9) NOT NULL
);
