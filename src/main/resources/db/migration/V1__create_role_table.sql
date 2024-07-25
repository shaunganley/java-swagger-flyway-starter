CREATE TABLE Role (
    `id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `roleName` varchar(100),
    `location` varchar(255),
    `capability` varchar(255),
    `band` varchar(255),
    `closingDate` date,
    `status` varchar(100)
);