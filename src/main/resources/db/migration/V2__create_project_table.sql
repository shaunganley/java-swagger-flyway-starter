CREATE TABLE Project (

projectID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
projectName varchar(100) NOT NULL,
projectValue decimal(11,2) NOT NULL,
clientID int FOREIGN KEY REFERENCES Client(clientID)

);

INSERT INTO Project (projectName, projectValue, clientID)
VALUES ("Project One", 99.99, 1);

INSERT INTO Project (projectName, projectValue, clientID)
VALUES ("Project Two", 1047.48, 2);

INSERT INTO Project (projectName, projectValue, clientID)
VALUES ("Project Three", 11250.15, 1);