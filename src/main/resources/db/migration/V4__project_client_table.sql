CREATE TABLE project (
                        id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        name varchar(30),
                        value int,
                        technology varchar(20)
                        FOREIGN KEY (clientId) REFERENCES client(id)
);