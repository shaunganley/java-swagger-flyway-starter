CREATE TABLE Project(
    `ProjectID` int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `ProjectName` varchar(200) NOT NULL,
    `Value` decimal(10,2) NOT NULL,
    `Technologies` varchar(700) NOT NULL
);