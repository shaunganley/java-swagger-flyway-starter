CREATE TABLE Client(
    ClientID SMALLINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    fName varchar(60),
    lName varchar(60),
    PhoneNumber varchar(20),
    Address varchar(255)
);

INSERT INTO Client(ClientIDfName, lName, PhoneNumber, Address)
VALUES('1', Bob', 'Lorenzo', '07123456789', '12 Made-up Street, Belfast');