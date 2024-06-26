CREATE TABLE user (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    roleId int NOT NULL,
    FOREIGN KEY (roleId) REFERENCES role(id)
);