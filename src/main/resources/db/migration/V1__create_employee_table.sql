create table Employee
(
    empId     int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name      varchar(100)   NOT NULL,
    salary    decimal(11, 2) NOT NULL,
    bankAccNo varchar(12)    NOT NULL,
    nino      varchar(9)     NOT NULL
);
