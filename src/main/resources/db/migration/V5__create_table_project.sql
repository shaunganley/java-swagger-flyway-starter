CREATE TABLE project
(
    id       INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    clientID int,
    techLead varchar(255) NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (clientID) REFERENCES client (id)
);