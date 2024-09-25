create table user (
    id int primary key auto_increment not null,
    username varchar(100) not null,
    password varchar(100) not null,
    role_id int foreign key not null
);
