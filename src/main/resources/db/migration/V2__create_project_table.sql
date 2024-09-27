CREATE TABLE project (
    projectId int NOT NULL AUTO_INCREMENT,
    `name` varchar(50),
    `value` decimal(11, 2),
    technologyId int,
    techLeadId int,
    clientId int,
    salesEmployeeId int,
    startDate DateTime,
    finishDate DateTime,
    commissionRate decimal(3, 2),
    PRIMARY KEY(projectId)
);
