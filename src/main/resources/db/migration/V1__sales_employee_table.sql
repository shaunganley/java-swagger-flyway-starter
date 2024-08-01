CREATE TABLE salesEmployee (
                               id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
                               name varchar(30),
                               salary decimal(9,2),
                               accountNumber varchar(34),
                               nationalInsuranceNumber varchar (9),
                               commissionRate decimal(3,1)
);