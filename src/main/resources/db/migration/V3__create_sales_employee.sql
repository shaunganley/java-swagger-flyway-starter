CREATE TABLE salesEmployees (
    salesEmployeeId INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    bankAccountNo VARCHAR(34) NOT NULL,
    nationalInsuranceNo CHAR(9),
    PRIMARY KEY(salesEmployeeId)
);
