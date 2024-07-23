CREATE TABLE `User`(
    Email varchar(30) PRIMARY KEY NOT NULL,
    Salt varchar(250) NOT NULL,
    Hash varchar(250) NOT NULL,
    RoleId int NOT NULL
);
