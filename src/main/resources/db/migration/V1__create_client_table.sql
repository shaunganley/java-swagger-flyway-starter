CREATE TABLE `client` (
    id int AUTO_INCREMENT NOT NULL,
    name nvarchar(50) NOT NULL,

    # Address
    street1 nvarchar(50) NOT NULL,
    street2 nvarchar(50),
    town nvarchar(50),
    city nvarchar(50),
    zip nvarchar(10) NOT NULL,
    country char(2) NOT NULL

    phone varchar(15)
)
