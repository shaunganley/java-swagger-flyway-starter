CREATE TABLE users (

    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(20) NOT NULL,
    password varchar (20) NOT NULL,
    roleID int,
    FOREIGN KEY (roleID) REFERENCES role(id)

);