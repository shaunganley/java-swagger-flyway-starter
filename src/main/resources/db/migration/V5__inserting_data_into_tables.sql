INSERT INTO capability (capabilityId, capabilityName) VALUES (1, 'Software Development');
INSERT INTO capability (capabilityId, capabilityName) VALUES (2, 'Data Science');
INSERT INTO capability (capabilityId, capabilityName) VALUES (3, 'Cyber Security');

INSERT INTO band (nameId, bandName) VALUES (1, 'Junior');
INSERT INTO band (nameId, bandName) VALUES (2, 'Mid');
INSERT INTO band (nameId, bandName) VALUES (3, 'Senior');
INSERT INTO band (nameId, bandName) VALUES (4, 'Lead');

INSERT INTO status (statusId, statusName) VALUES (1, 'Open');
INSERT INTO status (statusId, statusName) VALUES (2, 'Closed');

INSERT INTO job_roles (jobRoleId, roleName, location, capabilityId, bandId, closingDate)
VALUES (1, 'Software Engineer', 'New York', 1, 2, '2024-09-30 23:59:59');

INSERT INTO job_roles (jobRoleId, roleName, location, capabilityId, bandId, closingDate)
VALUES (2, 'Data Scientist', 'San Francisco', 2, 3, '2024-10-15 23:59:59');

INSERT INTO job_roles (jobRoleId, roleName, location, capabilityId, bandId, closingDate)
VALUES (3, 'Cyber Security Analyst', 'Washington D.C.', 3, 4, '2024-11-01 23:59:59');

INSERT INTO job_roles (jobRoleId, roleName, location, capabilityId, bandId, closingDate)
VALUES (4, 'Junior Developer', 'Chicago', 1, 1, '2024-12-20 23:59:59');