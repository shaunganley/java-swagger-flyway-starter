CREATE TABLE Client
(
    ClientID   INT PRIMARY KEY AUTO_INCREMENT,
    ClientName VARCHAR(100),
    SalesEmpID INT,

    FOREIGN KEY (SalesEmpID) REFERENCES
        SalesEmployee(SalesID)

);

CREATE TABLE Project (
                         ProjectID INT PRIMARY KEY AUTO_INCREMENT,
                         ProjectName VARCHAR(100),
                         IsCompleted BOOLEAN DEFAULT FALSE,
                         ClientID INT,
                         `Value` INT,
                         TechLeadID INT,
                         CHECK (Value<=10),
                         FOREIGN KEY (TechLeadID) REFERENCES
                             DeliveryEmployee(DeliveryID),
                         FOREIGN KEY (ClientID) REFERENCES
                            Client(ClientID)
);