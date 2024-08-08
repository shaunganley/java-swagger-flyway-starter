ALTER TABLE Projects
RENAME Project;

CREATE TABLE ProjectDeliveryEmp (
	ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	ProjectID int,
    DeliveryEmpID int,
    FOREIGN KEY (ProjectID) REFERENCES Project(ID),
    FOREIGN KEY (DeliveryEmpID) REFERENCES DeliveryEmployee(ID)
);

-- Work on a project
INSERT INTO ProjectDeliveryEmp (ProjectID, DeliveryEmpID)
VALUES (1, 1);

-- Work on another project (multiple projects)
INSERT INTO ProjectDeliveryEmp (ProjectID, DeliveryEmpID)
VALUES (2, 1);

-- Another delivery employee can also work on that project
INSERT INTO ProjectDeliveryEmp (ProjectID, DeliveryEmpID)
VALUES (1, 2);