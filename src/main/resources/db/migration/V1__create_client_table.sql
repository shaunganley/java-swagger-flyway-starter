CREATE TABLE `client` (
    clientId int AUTO_INCREMENT NOT NULL,
    name nvarchar(50) NOT NULL,
    addressLine1 nvarchar(50) NOT NULL,
    addressLine2 nvarchar(50),
    town nvarchar(50),
    city nvarchar(50),
    postcode nvarchar(10),
    country char(2) NOT NULL
    phone varchar(15)
)