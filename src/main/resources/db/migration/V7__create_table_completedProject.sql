CREATE TABLE completedProject
(
    id       INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    clientID int,
    techLead varchar(255) NOT NULL,
    value    decimal(10, 2);
CONSTRAINT fk_client2 FOREIGN KEY (clientID) REFERENCES client(id)
);