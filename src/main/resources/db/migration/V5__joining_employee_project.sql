create table Schedule(
    DeliveryEmployee_ID int,
    Project_ProjectID int,
    WorkingDate timestamp,
    primary key (DeliveryEmployee_ID, Project_ProjectID)
);

alter table Schedule
add constraint fk_schedule_DeliveryEmployee_ID
foreign key (DeliveryEmployee_ID)
references DeliveryEmployees(DeliveryEmployee_ID);

alter table Schedule
add constraint fk_schedule_Project_ProjectID
foreign key (Project_ProjectID)
references Project(Project_ProjectID);

