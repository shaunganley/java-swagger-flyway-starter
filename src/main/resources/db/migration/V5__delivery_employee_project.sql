CREATE TABLE deliveryEmployeeProject (
                        id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        projectID int NOT NULL,
                        deliveryEmpID int NOT NULL,

                        FOREIGN KEY (projectID) REFERENCES project(id),
                        FOREIGN KEY (deliveryEmpID) REFERENCES delivery_employee(id)

);