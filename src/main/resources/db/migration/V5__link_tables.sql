create table WorksOn (
    DeliveryID int not null,
    ProjectID int not null,

    FOREIGN KEY (DeliveryID) REFERENCES DeliveryEmployee(DeliveryID),
    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID)
);

CREATE TABLE ClientProject (
    ProjectID int not null,
    ClientID int not null,

    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
    FOREIGN KEY (ClientID) REFERENCES Client(ClientID)
);