CREATE TABLE employee
(
    id                INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name              VARCHAR(100) NOT NULL,
    salary double NOT NULL,
    bankNumber        char(32),
    nationalInsurance char(9)
);

CREATE TABLE sales
(
    id             INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    commissionRate decimal(2, 2) NOT NULL,
    employeeID     int,
    CONSTRAINT fk_employeeSales FOREIGN KEY (employeeID) REFERENCES employee (id)
);

CREATE TABLE delivery
(
    id         INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employeeID int,
    CONSTRAINT fk_employeeDelivery FOREIGN KEY (employeeID) REFERENCES employee (id)
);

CREATE TABLE techLead
(
    id      INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    deliveryID int,
    CONSTRAINT fk_delivery FOREIGN KEY (deliveryID) REFERENCES delivery (id)
);

CREATE TABLE client
(
    id      INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    salesID int,
    CONSTRAINT fk_sales FOREIGN KEY (salesID) REFERENCES sales (id)
);

CREATE TABLE project (
                        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        projectName varchar(255) NOT NULL,
                        projectValue decimal(11, 2) NOT NULL,
                        techLeadID int,
                        clientID int,
                        CONSTRAINT fk_client FOREIGN KEY (clientID) REFERENCES client(id),
                        CONSTRAINT fk_techLead FOREIGN KEY (techLeadID) REFERENCES techLead(id)
);

CREATE TABLE deliveryProject
(
    deliveryID int,
    projectID  int,
    primary key (deliveryID, projectID),
    CONSTRAINT fk_delivery2 FOREIGN KEY (deliveryID) REFERENCES delivery (id),
    CONSTRAINT fk_project FOREIGN KEY (projectID) REFERENCES project (id)
);

CREATE TABLE completedProject
(
    id       INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    clientID int,
    techLead varchar(255) NOT NULL,
    value    decimal(10, 2),
CONSTRAINT fk_client2 FOREIGN KEY (clientID) REFERENCES client(id)
);

INSERT INTO employee (id, Name, Salary, bankNumber, nationalInsurance)
VALUES (1, 'Alice Johnson', 55000.00, 'GB29NWBK60161331926819', 'QQ123456C'),
       (2, 'Bob Smith', 62000.00, 'GB82WEST12345698765432', 'QQ654321D'),
       (3, 'Charlie Brown', 48000.00, 'GB33BUKB20201555555555', 'QQ789012E'),
       (4, 'Diana Prince', 75000.00, 'GB94BARC20201512345678', 'QQ345678F'),
       (5, 'Evan Wright', 53000.00, 'GB12LOYD30963412345678', 'QQ901234G'),
       (6, 'John Doe', 50000, '12345678', 'AB123456C'),
       (7, 'Jane Smith', 55000, '87654321', 'CD234567D'),
       (8, 'Bob Brown', 45000, '44332211', 'GH456789F'),
       (9, 'Charlie Davis', 70000, '55667788', 'IJ567890G'),
       (10, 'Emily Wilson', 65000, '88776655', 'KL678901H'),
       (11, 'Frank Miller', 52000, '99887766', 'MN789012I'),
       (12, 'Grace Lee', 48000, '66778899', 'OP890123J'),
       (13, 'Henry Clark', 58000, '77665544', 'QR901234K'),
       (14, 'Isabella Lewis', 62000, '33445566', 'ST012345L');

INSERT INTO sales (id, commissionRate, employeeID)
VALUES (1, 0.15, 2),
       (2, 0.1, 5),
       (3, 0.1, 9),
       (4, 0.2, 11);

INSERT INTO delivery (id, employeeID)
VALUES (1, 1),
       (2, 3),
       (3, 4),
       (4, 6),
       (5, 7),
       (6, 8),
       (7, 10),
       (8, 12),
       (9, 13),
       (10, 14);

INSERT INTO techLead (id, deliveryID)
VALUES (1, 1),
       (2, 3),
       (3, 4),
       (4, 6),
       (5, 7),
       (6, 8),
       (7, 5),
       (8, 2),
       (9, 10),
       (10, 9);

INSERT INTO client (id, salesID)
VALUES (1, 1),
       (2, 3),
       (3, 4),
       (4, 3);

INSERT INTO project (id, projectName, projectValue, techLeadID, clientID)
VALUES (1, 'Project1', 10000000.00, 1, 1),
       (2, 'Project2', 2000000.00, 3, 2),
       (3, 'Project3', 12000000.00, 4, 4),
       (4, 'Project4', 47000000.00, 9, 3);

INSERT INTO deliveryProject (deliveryID, projectID)
VALUES (1, 1),
       (10, 2),
       (4, 3),
       (2, 3),
       (5, 4),
       (3, 4),
       (7, 4),
       (8, 4);