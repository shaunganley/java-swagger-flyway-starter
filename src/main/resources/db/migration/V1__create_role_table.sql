CREATE TABLE Role (
    ID int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    Title varchar(100) NOT NULL
);

INSERT INTO Role (Title)
VALUES('Admin'),('User');