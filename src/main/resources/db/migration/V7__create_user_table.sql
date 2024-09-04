CREATE TABLE IF NOT EXISTS `User`(
    `email` VARCHAR(64) PRIMARY KEY NOT NULL,
    `password` VARCHAR(256) NOT NULL,
    `roleId` tinyint NOT NULL,
    FOREIGN KEY (roleID) REFERENCES Role(RoleID)
);

INSERT INTO `User`(`email`, `password`, `roleId`)
VALUES  ('admin@email.com', '$argon2id$v=19$m=10,t=10,p=1$dmtOVE9YOFpYeEZ0eUMwag$4KyzLnN29i5nAldvXHigNbM60rzs3OBXo+mEZBpbG6Y', 1),
        ('user@email.com', '$argon2id$v=19$m=10,t=10,p=1$dmtOVE9YOFpYeEZ0eUMwag$QMB+2374mggfrGtR94+h3xbHmYVuZ1YbFvYSD6EjUHA', 2);