CREATE TABLE deliveryProject
(
    deliveryID int,
    projectID  int,
    primary key (deliveryID, projectID),
    CONSTRAINT fk_delivery FOREIGN KEY (deliveryID) REFERENCES delivery (id),
    CONSTRAINT fk_project FOREIGN KEY (projectID) REFERENCES project (id)
);