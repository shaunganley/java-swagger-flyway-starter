CREATE TABLE job_roles (
    jobRoleId INT PRIMARY KEY,
    roleName VARCHAR(70) NOT NULL,
    location ENUM('Belfast', 'Atlanta', 'Indianapolis', 'Buenos Aires', 'Antwerp', 'Toronto', 'Copenhagen', 'Helsinki', 'Paris', 'Frankfurt am Main', 'Gdańsk'),
    capabilityId INT,
    bandId INT,
    closingDate DATE,
    FOREIGN KEY (capabilityId) REFERENCES capability(capabilityId),
    FOREIGN KEY (bandId) REFERENCES band(bandId)
);
