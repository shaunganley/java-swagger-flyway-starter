create table Client
(
    clientId   int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name       varchar(100) NOT NULL,
    salesEmpId int          NOT NULL,
    FOREIGN KEY (salesEmpId) references salesEmployee (salesEmpId)
);


