CREATE TABLE `client` (
    clientId int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name nvarchar(50) NOT NULL,
    addressLine1 varchar(50) NOT NULL,
    addressLine2 varchar(50),
    town varchar(50),
    city varchar(50),
    postcode varchar(10),
    country char(2) NOT NULL,
    phone varchar(15),
    email varchar(50)
)