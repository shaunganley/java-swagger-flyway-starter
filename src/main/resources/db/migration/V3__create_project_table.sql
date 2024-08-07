CREATE TABLE project (
    projectID INT PRIMARY KEY AUTO_INCREMENT,
    `value` DECIMAL(10, 2) NOT NULL,
    technologyList SET('Java', 'PHP', 'SQL', 'Other'),
    leadName varchar(50) NOT NULL
);
