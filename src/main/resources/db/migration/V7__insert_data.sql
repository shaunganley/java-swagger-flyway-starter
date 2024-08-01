insert into client(clientID, name, address, phoneNo) values (1, 'james', 'address', '0308400308');
insert into client(clientID, name, address, phoneNo) values (2, 'john',  'address3', '0308400304');
insert into sales (Name, salary, bankAcc_No, nino) values ('Luke', 10000.00, 1002034, 'Mick');
insert into client(clientID, name, address, phoneNo) values (3, 'frank', 'address', '0308400308');
insert into client(clientID, name, address, phoneNo) values (4, 'John', 'address', '0308400308');
insert into client(clientID, name, address, phoneNo) values (5, 'jason', 'address', '0308400308');
insert into client(clientID, name, address, phoneNo) values (6, 'shea', 'address', '0308400308');

Select `value`, client.name
from project
         join client ON client.clientID
having max(`value`);

Select `value`, client.name
from project
         join client ON client.clientID
having min(`value`);

INSERT INTO sales (name, salary, bankAcc_No, nino, commission) VALUES
                                                                   ('Alice Johnson', 55000.00, '123456789012', 'AB123456C', 5000.00),
                                                                   ('Bob Smith', 60000.00, '987654321098', 'CD234567D', 7000.00),
                                                                   ('Carol White', 58000.00, '567890123456', 'EF345678E', 6500.00),
                                                                   ('David Brown', 62000.00, '210987654321', 'GH456789F', 8000.00),
                                                                   ('Eva Green', 54000.00, '345678901234', 'IJ567890G', 4500.00);

INSERT INTO delivery (name, salary, bankAcc_No, nino) VALUES
                                                          ('Tom Wilson', 32000.00, '123456789012', 'ZW123456A'),
                                                          ('Nancy Drew', 35000.00, '987654321098', 'XY234567B'),
                                                          ('Jake Harris', 30000.00, '567890123456', 'CD345678C'),
                                                          ('Laura King', 33000.00, '210987654321', 'EF456789D'),
                                                          ('Sam Brown', 31000.00, '345678901234', 'GH567890E');

INSERT INTO project (`value`, technologyList, leadName) VALUES
                                                            (25000.00, 'Java,SQL', 'Alice Johnson'),
                                                            (35000.00, 'PHP,SQL', 'Bob Smith'),
                                                            (15000.00, 'Java', 'Carol White'),
                                                            (45000.00, 'Java,PHP,SQL', 'David Brown'),
                                                            (30000.00, 'SQL', 'Eva Green');

SELECT s.salesID, s.name, s.salary, s.bankAcc_No, s.nino, s.commission
FROM sales s
         LEFT JOIN client c ON s.salesID = c.salesID
WHERE c.salesID IS NULL;

Select  client.name, `value`
from project
         join client ON client.clientID
group by client.name
having avg(`value`);

SELECT
    salesID, name, commission
FROM
    sales;