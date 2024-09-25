CREATE TABLE user (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    role_id int NOT NULL
);

ALTER TABLE user
ADD CONSTRAINT fk_user_role_id
FOREIGN KEY(role_id)
REFERENCES role(id);