CREATE table `user`(
    id int auto_increment,
    name varchar(20),
    password varchar(50),
    roleid int,
    primary key (id),
    foreign key (roleid) references role(id)
);