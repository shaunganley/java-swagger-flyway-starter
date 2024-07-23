CREATE TABLE location (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL,
    address varchar(250) NOT NULL,
    phone varchar(20) NOT NULL
    );

INSERT INTO location (name, address, phone) VALUES
('New York', '123 5th Ave, New York, NY 10001', '212-555-1234'),
('San Francisco', '456 Market St, San Francisco, CA 94103', '415-555-5678'),
('Chicago', '789 Wacker Dr, Chicago, IL 60601', '312-555-9012'),
('Los Angeles', '101 Hollywood Blvd, Los Angeles, CA 90028', '323-555-3456'),
('Boston', '202 Beacon St, Boston, MA 02116', '617-555-7890');