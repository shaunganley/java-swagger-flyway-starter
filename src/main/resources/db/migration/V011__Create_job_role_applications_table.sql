CREATE TABLE job_role_applications (
    jobRoleId INT NOT NULL,
    Email VARCHAR(255) NOT NULL,
    status ENUM('in progress', 'accepted', 'rejected') NOT NULL,
    PRIMARY KEY (jobRoleId, Email),
    FOREIGN KEY (jobRoleId) REFERENCES job_roles(jobRoleId) ON DELETE CASCADE,
    FOREIGN KEY (Email) REFERENCES User(Email) ON DELETE CASCADE
);
