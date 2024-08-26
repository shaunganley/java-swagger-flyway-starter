CREATE TABLE job_roles (
    jobRoleId INT PRIMARY KEY,
    roleName VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    capabilityId INT,
    bandId INT,
    closingDate DATE,
    FOREIGN KEY (capabilityId) REFERENCES capability(capabilityId),
    FOREIGN KEY (bandId) REFERENCES band(bandId)
);
