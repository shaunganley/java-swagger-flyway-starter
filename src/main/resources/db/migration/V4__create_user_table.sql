CREATE TABLE user (
    userID int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(100) NOT NULL,
    password varchar(100),
    roleID smallint
);
