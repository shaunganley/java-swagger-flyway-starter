CREATE TABLE jobRoles (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    role_name VARCHAR(100) NOT NULL,
    location_id INT NOT NULL,
    capability_id INT NOT NULL,
    band_id INT NOT NULL,
    closing_date DATE NOT NULL,
    status ENUM('open', 'closed'),
    FOREIGN KEY (location_id) REFERENCES location(id),
    FOREIGN KEY (capability_id) REFERENCES capability(id),
    FOREIGN KEY (band_id) REFERENCES band(id)
);

INSERT INTO jobRoles (role_name, location_id, capability_id, band_id, closing_date, status) VALUES
('Software Engineer', 1, 1, 1, '2024-12-31', 'open'),
('Software Engineer', 2, 1, 2, '2024-11-30', 'open'),
('Software Engineer', 3, 1, 3, '2024-10-31', 'open'),
('Data Scientist', 1, 2, 1, '2024-09-30', 'closed'),
('Data Scientist', 2, 2, 2, '2024-08-31', 'closed'),
('Data Scientist', 3, 2, 3, '2024-07-31', 'closed'),
('Product Manager', 1, 3, 1, '2024-06-30', 'open'),
('Product Manager', 2, 3, 2, '2024-05-31', 'open'),
('Product Manager', 3, 3, 3, '2024-04-30', 'open'),
('UX Designer', 1, 4, 1, '2024-03-31', 'closed'),
('UX Designer', 2, 4, 2, '2024-02-29', 'closed'),
('UX Designer', 3, 4, 3, '2024-01-31', 'closed'),
('DevOps Engineer', 1, 5, 1, '2023-12-31', 'closed'),
('DevOps Engineer', 2, 5, 2, '2023-11-30', 'closed'),
('DevOps Engineer', 3, 5, 3, '2023-10-31', 'closed'),
('Software Engineer', 4, 1, 4, '2023-09-30', 'closed'),
('Data Scientist', 4, 2, 5, '2023-08-31', 'closed'),
('Product Manager', 4, 3, 4, '2023-07-31', 'closed'),
('UX Designer', 4, 4, 5, '2023-06-30', 'closed'),
('DevOps Engineer', 4, 5, 4, '2023-05-31', 'closed');
