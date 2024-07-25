CREATE TABLE location (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL,
    address varchar(250) NOT NULL,
    phone varchar(20) NOT NULL
    );

INSERT INTO location (name, address, phone) VALUES
('Belfast', '4-6 Upper Cres, Belfast, BT7 1NT', '028 9057 1100'),
('Birmingham', '5th Floor, Cornerblock, 2 Cornwall St, Birmingham, B3 2DX, United Kingdom', '+44 28 9057 1100'),
('Derry', '5th Floor Timber Quay, Strand Road, BT48 7NR, United Kingdom', '+44 28 9057 1100'),
('Buenos Aires', 'Charcas 5150, C1425 BOE, Buenos Aires, Argentina', '+1 470 467 8596'),
('Toronto', 'Suite 2200, Commerce Court North, 25 King Street West, Toronto, M5L 2A1', '+1 647 931 0589');