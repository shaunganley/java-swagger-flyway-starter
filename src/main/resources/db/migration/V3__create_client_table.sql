CREATE TABLE Client (
    id int AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    address varchar(100) NOT NULL,
    phone varchar(18) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Client (name, address, phone)
VALUES ('Sam Dagnall', '123 Aurora Drive', '+44 07484 260280');


INSERT INTO Client (name, address, phone)
VALUES ('Schmam Schmagnall', '2 Cornwall Street', '+125 08259 201910');

INSERT INTO Client (name, address, phone)
VALUES ('Tom Billington', '56 Sir Henry Parkes Road', '+27 87112 101021');



