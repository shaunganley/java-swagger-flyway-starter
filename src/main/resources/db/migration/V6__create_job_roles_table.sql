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