CREATE TABLE role (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL
);

INSERT INTO role (name) VALUES
('Manager'),
('Developer'),
('Analyst'),
('Consultant'),
('Engineer');