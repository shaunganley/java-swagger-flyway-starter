create table clients(
    client_ID smallint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    client_name varchar(30),
    client_address varchar(60),
    client_phone_number char(11),
    project_ID smallint
)