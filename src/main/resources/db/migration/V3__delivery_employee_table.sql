CREATE TABLE deliveryEmployee
(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    empId int NOT NULL,
    FOREIGN KEY (empId) REFERENCES Employee(empId)
);
