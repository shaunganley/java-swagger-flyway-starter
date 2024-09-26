CREATE TABLE project (
    projectId int NOT NULL AUTO_INCREMENT,
    `name` varchar(50),
    `value` decimal(9, 2),
    technologyId int,
    techLeadId int,
    clientId int,
    salesEmployeeID int,
    startDate DateTime,
    finishDate DateTime,
    PRIMARY KEY(projectId)
);
