CREATE TABLE employee (
                      id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      name VARCHAR(100) NOT NULL,
                      salary double NOT NULL,
                      bankNumber char(32),
                      nationalInsurance char(9)
);