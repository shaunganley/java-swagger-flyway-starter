CREATE TABLE projectDeliveryEmployees (
    projectId int NOT NULL,
    deliveryEmployeeId int NOT NULL,
    employeeStartDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    employeeFinishDate DATETIME,
    FOREIGN KEY(projectId) REFERENCES project(projectId),
    FOREIGN KEY(deliveryEmployeeId) REFERENCES deliveryEmployee(deliveryEmployeeId)
);