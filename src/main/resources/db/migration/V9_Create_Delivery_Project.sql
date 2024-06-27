CREATE TABLE delivery_project(
VALUES deliveryID int PRIMARY KEY AUTO_INCREMENT NOT NULL,
projectID int, FOREIGN KEY(projectID) REFERENCES Project (projectID),
active boolean
);