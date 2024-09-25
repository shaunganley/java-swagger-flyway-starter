create table user (
id int primary key auto_increment not null,
username varchar(50) not null,
password varchar(50) not null,
role_id int not null,
foreign key (role_id) references role(id)
);