CREATE TABLE IF NOT EXISTS `Role`(
    `roleId` tinyint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `roleName`VARCHAR(64) NOT NULL
);

INSERT INTO `Role`(`roleName`)
VALUES ('ADMIN'),
       ('USER');
