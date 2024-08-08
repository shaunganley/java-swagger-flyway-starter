CREATE TABLE DeliveryEmployees (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50),
    salary decimal(10, 2) NOT NULL,
    bank_acc varchar(8) UNIQUE NOT NULL,
    ni varchar(9) UNIQUE NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE SalesEmployees (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50),
    salary decimal(10, 2) NOT NULL,
    bank_acc varchar(8) UNIQUE NOT NULL,
    ni varchar(9) UNIQUE NOT NULL,
    commissionRate decimal(3, 1) NOT NULL,
    PRIMARY KEY (ID)
);


CREATE TABLE Client (
    id int AUTO_INCREMENT NOT NULL,
    salesEmpID int,
    PRIMARY KEY (id),
    KEY `fk_salesEmpId` (`salesEmpID`),
    CONSTRAINT `fk_salesEmpId` FOREIGN KEY (`salesEmpID`) REFERENCES `SalesEmployees` (id)
);

CREATE TABLE Projects(
     id int AUTO_INCREMENT,
     name varchar(50) NOT NULL,
     value decimal(12,2),
     clientID int,
     completed bool DEFAULT FALSE,
     PRIMARY KEY (id),
     KEY `fk_clientid` (`clientID`),
     CONSTRAINT `fk_clientid` FOREIGN KEY (`clientID`) REFERENCES `Client` (`id`)
);
CREATE TABLE EmpProject (
    id int AUTO_INCREMENT NOT NULL,
    empID int NOT NULL,
    projID int NOT NULL,
    techLead bool DEFAULT FALSE,
    onProject bool DEFAULT TRUE,
    PRIMARY KEY (id),
    Key `fk_empid` (`empID`),
    CONSTRAINT `fk_empid` FOREIGN KEY (`empID`) REFERENCES `DeliveryEmployees` (id),
    Key `fk_projid` (`projID`),
    CONSTRAINT `fk_projid` FOREIGN KEY (`projID`) REFERENCES `Projects` (id)
);