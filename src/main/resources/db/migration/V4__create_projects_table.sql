CREATE TABLE Projects(
    id int AUTO_INCREMENT,
    Name varchar(50) NOT NULL,
    Value tinyint DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE Technology(
    id int AUTO_INCREMENT,
    Name varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ProjectTech(
    ProjectID int NOT NULL,
    TechID int NOT NULL,
    FOREIGN KEY (ProjectID) REFERENCES Projects(id),
    FOREIGN KEY (TechID) REFERENCES Technology(id),
    PRIMARY KEY (ProjectID, TechID)
);

INSERT INTO Projects (Name, Value)
VALUES ('Database Migration', 5);

INSERT INTO Projects(Name, Value)
VALUES ('Waiting for PR Review', 2);

INSERT INTO Technology (Name)
VALUES ('GitHub');

INSERT INTO Technology (Name)
VALUES ('IntelliJ');

INSERT INTO ProjectTech VALUES (1, 2);

INSERT INTO ProjectTech VALUES (1,1);

INSERT INTO ProjectTech VALUES (2,1);