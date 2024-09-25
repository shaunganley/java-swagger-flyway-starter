CREATE TABLE user (
                      id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      username varchar(50) NOT NULL,
                      password varchar(50) NOT NULL,
                      roleId int NOT NULL,
                      FOREIGN KEY (roleId) REFERENCES role(id)
)
