CREATE TABLE salesEmployees (
    salesEmployeeId int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    firstName nvarchar(50) NOT NULL,
    lastName nvarchar(50) NOT NULL,
    salary decimal(10,2) NOT NULL,
    currency char(3) NOT NULL,
    bankAccountNo varchar(34) NOT NULL,
    nationalInsuranceNo char(9),
)
