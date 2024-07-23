CREATE TABLE role (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL
);

CREATE TABLE location (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL,
    address varchar(250) NOT NULL,
    phone varchar(20) NOT NULL
    );

CREATE TABLE capability (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL
);

CREATE TABLE band (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name char(1) NOT NULL
);

CREATE TABLE jobRoles (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    role_id INT NOT NULL,
    location_id INT NOT NULL,
    capability_id INT NOT NULL,
    band_id INT NOT NULL,
    closing_date DATE NOT NULL,
    status ENUM('open','closed'),
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (location_id) REFERENCES location(id),
    FOREIGN KEY (capability_id) REFERENCES capability(id),
    FOREIGN KEY (band_id) REFERENCES band(id)
);

INSERT INTO role (name) VALUES
('Manager'),
('Developer'),
('Analyst'),
('Consultant'),
('Engineer');

INSERT INTO location (name, address, phone) VALUES
('New York', '123 5th Ave, New York, NY 10001', '212-555-1234'),
('San Francisco', '456 Market St, San Francisco, CA 94103', '415-555-5678'),
('Chicago', '789 Wacker Dr, Chicago, IL 60601', '312-555-9012'),
('Los Angeles', '101 Hollywood Blvd, Los Angeles, CA 90028', '323-555-3456'),
('Boston', '202 Beacon St, Boston, MA 02116', '617-555-7890');

INSERT INTO capability (name) VALUES
('Leadership'),
('Coding'),
('Analysis'),
('Consulting'),
('Engineering');

INSERT INTO band (name) VALUES
('A'),
('B'),
('C'),
('D'),
('E');

INSERT INTO jobRoles (role_id, location_id, capability_id, band_id, closing_date, status) VALUES
(1, 1, 1, 1, '2024-12-31', 'open'),
(1, 2, 1, 2, '2024-11-30', 'open'),
(1, 3, 1, 3, '2024-10-31', 'open'),
(2, 1, 2, 1, '2024-09-30', 'closed'),
(2, 2, 2, 2, '2024-08-31', 'closed'),
(2, 3, 2, 3, '2024-07-31', 'closed'),
(3, 1, 3, 1, '2024-06-30', 'open'),
(3, 2, 3, 2, '2024-05-31', 'open'),
(3, 3, 3, 3, '2024-04-30', 'open'),
(4, 1, 4, 1, '2024-03-31', 'closed'),
(4, 2, 4, 2, '2024-02-29', 'closed'),
(4, 3, 4, 3, '2024-01-31', 'closed'),
(5, 1, 5, 1, '2023-12-31', 'closed'),
(5, 2, 5, 2, '2023-11-30', 'closed'),
(5, 3, 5, 3, '2023-10-31', 'closed'),
(1, 4, 1, 4, '2023-09-30', 'closed'),
(2, 4, 2, 5, '2023-08-31', 'closed'),
(3, 4, 3, 4, '2023-07-31', 'closed'),
(4, 4, 4, 5, '2023-06-30', 'closed'),
(5, 4, 5, 4, '2023-05-31', 'closed');

