CREATE TABLE Role (
    `id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `roleName` varchar(100),
    `location` varchar(255),
    `capabilityID` int,
    `bandID` int,
    `closingDate` date,
    `status` varchar(100),
    foreign key (capabilityID) references Capability(capabilityID),
    foreign key (bandID) references Band(bandID)
);