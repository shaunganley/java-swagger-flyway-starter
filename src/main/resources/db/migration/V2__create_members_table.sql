CREATE TABLE `Members` (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    register_date DATE NOT NULL
);

INSERT INTO Members (first_name, last_name, address, phone, email, register_date) VALUES
('Rackie', 'Pascua', '78-86 Dublin Road', '07389891341', 'rackiepascua@gmail.com', 28/06/24)
('Zita', 'Cheung', '61 Fitzwilliam Street', '0731234567', 'zitacheung@gmail.com', 28/06/24)
('Jerico', 'Atos', '78-86 Dublin Road', '07298984131', 'rackiepascua@gmail.com', 28/06/24);