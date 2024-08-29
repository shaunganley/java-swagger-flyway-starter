CREATE TABLE `User` (
    Email varchar(64) NOT NULL,
    Password varchar(64) NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (Email),
    FOREIGN KEY (role_id) REFERENCES `Role`(id)
);

INSERT INTO User( Email, Password, role_id) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 1);
INSERT INTO User( Email, Password, role_id) VALUES ('user', 'user', 2);