CREATE TABLE job_roles (
    jobRoleId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    roleName VARCHAR(70) NOT NULL,
    location ENUM('Belfast', 'Atlanta', 'Indianapolis', 'Buenos Aires', 'Antwerp', 'Toronto', 'Copenhagen', 'Helsinki', 'Paris', 'Frankfurt am Main', 'Gdańsk'),
    capabilityId INT,
    bandId INT,
    closingDate DATE,
    status ENUM('open', 'closed'),
    FOREIGN KEY (capabilityId) REFERENCES capability(capabilityId),
    FOREIGN KEY (bandId) REFERENCES band(bandId)
);
