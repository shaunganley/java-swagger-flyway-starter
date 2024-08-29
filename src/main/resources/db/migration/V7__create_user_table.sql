CREATE TABLE IF NOT EXISTS `User` (
                                      `email` VARCHAR(64) PRIMARY KEY NOT NULL,
    `password` VARCHAR(256) NOT NULL,
    `roleId` tinyint NOT NULL,
    FOREIGN KEY (roleID) REFERENCES Role(RoleID)
    );

INSERT INTO `User`(`email`, `password`, `roleId`)
VALUES  ('admin@email.com', '$argon2id$v=19$m=60000,t=10,p=1$osWewhkwSV5FkUs0cJnugg$QOA2RDScF9etxgLirmqYJGOdsZT+NkN6syS7WJoVSE0', 1),
        ('user@email.com', '$argon2id$v=19$m=60000,t=10,p=1$dmt OVE9YOFpYeEZ0eUMwag$O4YdchqdqIWLwl8SaEPbxIvvCyYiwa/TWF+euIU92R0', 2);