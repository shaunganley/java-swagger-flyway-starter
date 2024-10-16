CREATE TABLE projectDeliveryEmployees (
    projectId INT NOT NULL,
    deliveryEmployeeId INT NOT NULL,
    FOREIGN KEY(projectId) REFERENCES project(projectId),
    FOREIGN KEY(deliveryEmployeeId) REFERENCES deliveryEmployee(deliveryEmployeeId),
    PRIMARY KEY(projectId, deliveryEmployeeId)
);
