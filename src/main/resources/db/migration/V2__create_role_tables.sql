create table `Role`(
                       RoleID tinyint not null,
                       Name varchar(64) not null,
                       Primary key (RoleID)
);

insert into Role(RoleID, Name) Values (1, 'Admin');
insert into Role(RoleID, Name) Values (2, 'User');

create table User (
                      Username varchar(64) not null,
                      Password varchar(64) not null,
                      RoleID tinyint not null,
                      Primary key(Username),
                      Foreign key (RoleID) References Role(RoleID)
);

insert into User(Username, Password, RoleID) Values ('admin', 'admin', 1);
insert into User(Username, Password, RoleID) Values ('user', 'user', 2);