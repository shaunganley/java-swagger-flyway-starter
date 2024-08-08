create table Project
(

    projectId     int PRIMARY KEY AUTO_INCREMENT,
    name          varchar(100),
    value         decimal(11, 2),
    clientId      int  not null,
    techLeadId    int  not null,
    deliveryEmpId int  not null,
    completed     bool not null,

    FOREIGN KEY (clientId) REFERENCES Client(clientId),
    FOREIGN KEY (techLeadId) REFERENCES tech_lead(techLeadId),
    FOREIGN KEY (deliveryEmpId) REFERENCES deliveryEmployee(id)
);