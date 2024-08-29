
INSERT INTO capability (capabilityId, capabilityName) VALUES (1, 'Software Development');
INSERT INTO capability (capabilityId, capabilityName) VALUES (2, 'Data Science');
INSERT INTO capability (capabilityId, capabilityName) VALUES (3, 'Cyber Security');

INSERT INTO band (nameId, bandName) VALUES (1, 'Junior');
INSERT INTO band (nameId, bandName) VALUES (2, 'Mid');
INSERT INTO band (nameId, bandName) VALUES (3, 'Senior');
INSERT INTO band (nameId, bandName) VALUES (4, 'Lead');

INSERT INTO status (statusId, statusName) VALUES (1, 'Open');
INSERT INTO status (statusId, statusName) VALUES (2, 'Closed');

INSERT INTO job_roles (jobRoleId, roleName, location, capabilityId, bandId, closingDate, statusId) VALUES
(1, 'Software Engineer', 'New York', 1, 1, '2024-09-15 17:00:00', 1),
(2, 'Marketing Specialist', 'San Francisco', 2, 2, '2024-09-20 17:00:00', 1),
(3, 'Financial Analyst', 'Chicago', 3, 3, '2024-09-30 17:00:00', 2),
(4, 'Data Scientist', 'Seattle', 1, 2, '2024-10-05 17:00:00', 1),
(5, 'Digital Marketing Manager', 'Boston', 2, 1, '2024-10-10 17:00:00', 2);

