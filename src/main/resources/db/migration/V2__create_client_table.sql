CREATE TABLE Client(
    ClientID SMALLINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    fName varchar(60),
    lName varchar(60),
    PhoneNumber varchar(20),
    Address varchar(255)
);

INSERT INTO Client(fName, lName, PhoneNumber, Address)
VALUES('Bob', 'Lorenzo', '07123456789', '12 Made-up Street, Belfast');