CREATE TABLE user (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(30) NOT NULL,
    password varchar(50) NOT NULL,
    roleID int,
    FOREIGN KEY (roleID) REFERENCES role(id)
);