CREATE TABLE DeliveryEmployee (
    ID int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    salary decimal(10, 2) NOT NULL,
    bank_acc varchar(8) UNIQUE NOT NULL,
    ni varchar(9) UNIQUE NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO DeliveryEmployee (name, salary, bank_acc, ni)
VALUES ('John Go', 28888.00, 12345678, 'QQ123456B');

INSERT INTO DeliveryEmployee (name, salary, bank_acc, ni)
VALUES ('Tim No', 25000.00, 87654321, 'QQ654321C');