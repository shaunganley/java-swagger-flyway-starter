INSERT INTO SalesEmployee(firstName, LastName, salary, bankAccountNumber, nationalInsuranceNumber, commissionRate)
    VALUES (Adam,Bowman,100000, 1234567812345678, 123456781234, 10),
    VALUES (John,Smith,50000, 2234567812345671, 223456781234, 10),
    VALUES (Andrew,Brown,200000, 3234567812345672, 223456781234, 10),
    VALUES (Thomas,Yellow,30000, 4234567812345673, 223456781234, 10);

INSERT INTO Project(ProjectID, ProjectName, Value, Technologies)
    VALUES (1,'Database Project',5155.00,'mySQL'),(2,'Programming Project',4120.30,'Java'),
    (3,'API Project',11545.89,'Maven'),(4,'Website Creation',2400.50,'JavaScript'),
    (5,'Embedding API', 800.44,'Google Map API')
    );

INSERT INTO deliveryEmployee(fname,lname,salary,bankAccountNum,nationalInsureNum) Values ('Bob','Smith',22000,'1234567890','ABCD56TD');
INSERT INTO deliveryEmployee(fname,lname,salary,bankAccountNum,nationalInsureNum) Values ('Sam','Smith',36000,'0987654321','LKJK56TA');
INSERT INTO deliveryEmployee(fname,lname,salary,bankAccountNum,nationalInsureNum) Values ('Bill','Barker',99000,'1324354657','UYHV76YK');
INSERT INTO deliveryEmployee(fname,lname,salary,bankAccountNum,nationalInsureNum) Values ('Phil','Smith',78000,'0981234567','BHUT98TR');
INSERT INTO deliveryEmployee(fname,lname,salary,bankAccountNum,nationalInsureNum) Values ('Tracy','Smith',35000,'1234567890','NBVC76UY');

INSERT INTO client (name, address, phoneNumber)
VALUES ('FirstClient', '1 Client Street, Belfast', '07812345678');

INSERT INTO client (name, address, phoneNumber)
VALUES ('SecondClient', '2 University Street, Belfast', '07812375678');

INSERT INTO client (name, address, phoneNumber)
VALUES ('ThirdClient', '3 Church Hill, Ballygowan', '07812375835');

INSERT INTO client (name, address, phoneNumber)
VALUES ('FourthClient', '4 Hanwood Drive Street, Belfast', '07812379268');