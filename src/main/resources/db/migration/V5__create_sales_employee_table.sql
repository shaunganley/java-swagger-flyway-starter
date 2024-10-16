CREATE TABLE salesEmployees (
    salesEmployeeId INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    bankAccountNo VARCHAR(34) NOT NULL,
    nationalInsuranceNo CHAR(9)
)