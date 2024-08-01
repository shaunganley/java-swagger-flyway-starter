CREATE TABLE project (
                        id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        name varchar(30),
                        value int,
                        technology varchar(20),
                        clientId int NOT NULL,
                        FOREIGN KEY (clientId) REFERENCES client(id)
);