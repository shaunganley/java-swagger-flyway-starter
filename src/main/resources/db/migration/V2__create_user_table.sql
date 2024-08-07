CREATE TABLE user (
                      id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      username VARCHAR(100) NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      role_id INT,
                      CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES role(id)
);