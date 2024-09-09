CREATE TABLE application_status (
    statusApplicationId INT PRIMARY KEY AUTO_INCREMENT,
    statusApplicationName VARCHAR(50) NOT NULL
);

INSERT INTO application_status (statusApplicationName)
VALUES
    ('in progress'),
    ('hired'),
    ('rejected');

CREATE TABLE job_application (
    Email VARCHAR(64) NOT NULL,
    jobRoleId INT NOT NULL,
    statusApplicationId INT,
    PRIMARY KEY (Email, jobRoleId),
    FOREIGN KEY (statusApplicationId) REFERENCES application_status(statusApplicationId)
);
