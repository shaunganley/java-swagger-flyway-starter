CREATE TABLE SalesEmployee(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) not null,
    salary decimal(10,2) not null,
    bank_acc varchar(8) not null UNIQUE,
    ni varchar(9) not null UNIQUE,
    commission_rate decimal(5,2) not null default 0
);

INSERT INTO SalesEmployee(name, salary, bank_acc, ni, commission_rate)
 values
 ('Jemima',2500.50,'01234567','n043j8k13',10.3);

INSERT INTO SalesEmployee(name, salary, bank_acc, ni, commission_rate)
 values
 ('Zohaib',2600.75,'01266567','n063k8p83',9.3);