
Drop table project;

CREATE TABLE project (
    projectID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    projectName varchar(255),
    projectValue decimal(11,2),
    clientID smallint
    

)