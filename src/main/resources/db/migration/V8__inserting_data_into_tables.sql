
INSERT INTO capability (capabilityId, capabilityName) VALUES (1, 'Software Development');
INSERT INTO capability (capabilityId, capabilityName) VALUES (2, 'Data Science');
INSERT INTO capability (capabilityId, capabilityName) VALUES (3, 'Cyber Security');

INSERT INTO band (nameId, bandName) VALUES (1, 'Junior');
INSERT INTO band (nameId, bandName) VALUES (2, 'Mid');
INSERT INTO band (nameId, bandName) VALUES (3, 'Senior');
INSERT INTO band (nameId, bandName) VALUES (4, 'Lead');

INSERT INTO status (statusId, statusName) VALUES (1, 'Open');
INSERT INTO status (statusId, statusName) VALUES (2, 'Closed');

INSERT INTO job_roles (jobRoleId, roleName, location, capabilityId, bandId, closingDate, statusId, description, responsibilities, sharepointUrl, numberOfOpenPositions)
VALUES
    (1, 'Software Engineer', 'New York', 1, 1, '2024-09-15 17:00:00', 1,
     'Develops, tests, and maintains software applications.',
     'Design, develop, and maintain software applications, collaborate with other engineers, perform code reviews.',
     'https://sharepoint.com/job/software-engineer',
     3),

    (2, 'Marketing Specialist', 'San Francisco', 2, 2, '2024-09-20 17:00:00', 1,
     'Responsible for planning and executing marketing campaigns.',
     'Develop marketing strategies, create promotional materials, manage social media accounts.',
     'https://sharepoint.com/job/marketing-specialist',
     2),

    (3, 'Financial Analyst', 'Chicago', 3, 3, '2024-09-30 17:00:00', 2,
     'Analyzes financial data to support business decisions.',
     'Prepare financial reports, conduct variance analysis, support budgeting and forecasting activities.',
     'https://sharepoint.com/job/financial-analyst',
     1),

    (4, 'Data Scientist', 'Seattle', 1, 2, '2024-10-05 17:00:00', 1,
     'Uses statistical analysis and machine learning to solve business problems.',
     'Build predictive models, analyze large datasets, develop data-driven solutions.',
     'https://sharepoint.com/job/data-scientist',
     4),

    (5, 'Digital Marketing Manager', 'Boston', 2, 1, '2024-10-10 17:00:00', 2,
     'Leads digital marketing efforts and manages campaigns.',
     'Oversee digital marketing strategies, manage campaigns, analyze performance metrics, optimize marketing spend.',
     'https://sharepoint.com/job/digital-marketing-manager',
     2);
