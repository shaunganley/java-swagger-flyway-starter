create table Client (
	client_id smallInt auto_increment not null,
    client_name VARCHAR(50) not null,
    building_no VARCHAR(10) not null,
    street_name VARCHAR(50) not null,
    postcode VARCHAR(10) not null,
    city VARCHAR(100) not null,
    county VARCHAR(50),
    country VARCHAR(50),
    phone_number VARCHAR(11), -- Assume this is for UK numbers only!
    PRIMARY KEY (client_id)
);