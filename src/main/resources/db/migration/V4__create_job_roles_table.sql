create table job_roles (
	jobRoleId int not null,
    roleName varchar(255),
    location varchar(64),
    capabilityId int not null,
    bandId int not null,
    closingDate timestamp,
    statusId int not null,

    primary key (jobRoleId),
    foreign key (capabilityId) references capability(capabilityId),
    foreign key (bandId) references band(nameId),
    foreign key (statusId) references status(statusId)
);