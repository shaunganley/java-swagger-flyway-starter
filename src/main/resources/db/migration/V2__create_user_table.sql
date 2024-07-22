CREATE TABLE `User`(
    Email varchar(30) PRIMARY KEY NOT NULL,
    Password varchar(20) NOT NULL,
    RoleId int NOT NULL
);

INSERT INTO `User` (Email,Password,RoleId)
VALUES('eoghan@random.com','password223',1),
('kaja@random.com','password456',1),
('adam@random.com','password897',2);
