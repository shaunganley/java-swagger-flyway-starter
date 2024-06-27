create table user (
	user_id int NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role_id int,
    PRIMARY KEY (user_id),
    CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role(id),
    CONSTRAINT unique_uname UNIQUE (username)
);