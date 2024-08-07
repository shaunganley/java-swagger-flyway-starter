CREATE TABLE projectHistory (
    projectHistoryID int,
    `value` DECIMAL(10, 2) NOT NULL,
    technologyList SET('Java', 'PHP', 'SQL', 'Other'),
    leadName varchar(50) NOT NULL
);

create table projectDelivery (
    projectID int ,
    deliveryID int,
    PRIMARY KEY (projectID, deliveryID)
);

ALTER TABLE client
    ADD salesID int,
    ADD CONSTRAINT FK_ClientSales
    FOREIGN KEY (salesID) references sales(salesID);