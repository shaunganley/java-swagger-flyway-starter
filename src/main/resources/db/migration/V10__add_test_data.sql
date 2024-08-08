-- Data for the database --

-- Updating existing data in the Project table --
UPDATE Project
SET ClientID = 1
WHERE id = 1;

UPDATE Project
SET ClientID = 2
WHERE id = 2;

UPDATE Client
SET SalesEmployeeID = 1
WHERE id <>0;

-- Adding a client id to one of the project --
update Project set ClientID = 1
WHERE id = 1;

-- Test Data for SalesEmployee --
INSERT INTO SalesEmployee(name, salary, bank_acc, ni, commission_rate)
VALUES ('John Doe', 45000, '12345678', 'AB123456C', 0.05);

INSERT INTO SalesEmployee(name, salary, bank_acc, ni, commission_rate)
VALUES ('Jane Smith', 52000, '87654321', 'CD987654A', 0.07);

INSERT INTO SalesEmployee(name, salary, bank_acc, ni, commission_rate)
VALUES ('Alice Johnson', 48000, '11223344', 'EF112233B', 0.06);

INSERT INTO SalesEmployee(name, salary, bank_acc, ni, commission_rate)
VALUES ('Bob Brown', 50000, '44332211', 'GH443322C', 0.04);

INSERT INTO SalesEmployee(name, salary, bank_acc, ni, commission_rate)
VALUES ('Carol White', 47000, '55667788', 'IJ556677D', 0.05);


-- Test Data for DeliveryEmployee --
INSERT INTO DeliveryEmployee(name, salary, bank_acc, ni)
VALUES ('Tom Baker', 28000, '22334455', 'QW123456D');

INSERT INTO DeliveryEmployee(name, salary, bank_acc, ni)
VALUES ('Lucy Green', 32000, '66778899', 'ER987654B');

INSERT INTO DeliveryEmployee(name, salary, bank_acc, ni)
VALUES ('Samuel Lewis', 31000, '44556677', 'TY112233C');

INSERT INTO DeliveryEmployee(name, salary, bank_acc, ni)
VALUES ('Megan Turner', 29500, '88990011', 'UI445566D');

INSERT INTO DeliveryEmployee(name, salary, bank_acc, ni)
VALUES ('James White', 30500, '99887766', 'OP667788A');


-- Test Data for Client --

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Acme Ltd', '123 Business St, London, EC1A 1BB', '020 7946 0958', 1);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Globex UK', '456 Industrial Rd, Birmingham, B1 1AA', '0121 496 0678', 2);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Soylent Corp', '789 Corporate Ave, Manchester, M1 2WH', '0161 496 0765', 3);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Initech Ltd', '101 Office Park Dr, Cambridge, CB1 9NL', '01223 496 0321', 4);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Umbrella Corp', '202 Biohazard Blvd, Bristol, BS1 5DB', '0117 496 0789', 5);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Stark Industries', '303 Superhero Ln, London, W1A 0AX', '020 7946 0876', 1);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Wayne Enterprises', '404 Batcave Dr, Liverpool, L1 8JQ', '0151 496 0345', 2);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Wonka Industries', '505 Chocolate Factory Rd, York, YO1 7PX', '01904 496 0456', 3);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Oscorp', '606 Green Goblin Ln, Leeds, LS1 3AB', '0113 496 0567', 4);

INSERT INTO Client(name, address, phone, SalesEmployeeID)
VALUES ('Aperture Science', '707 Portal Blvd, Edinburgh, EH1 1YZ', '0131 496 0679', 5);


-- Test Data for Project --

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Alpha', 500000, 1, 1);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Beta', 750000, 2, 2);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Gamma', 300000, 3, 3);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Delta', 450000, 4, 4);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Epsilon', 600000, 5, 5);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Zeta', 550000, 6, 1);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Eta', 700000, 7, 2);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Theta', 400000, 8, 3);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Iota', 650000, 9, 4);

INSERT INTO Project(name, Value, ClientID, TechLeadID)
VALUES ('Project Kappa', 350000, 10, 5);



-- Test Data for ProjectDeliveryEmp --
INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (1, 1, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (2, 2, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (3, 3, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (4, 4, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (5, 5, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (6, 1, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (7, 2, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (8, 3, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (9, 4, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (10, 5, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (1, 2, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (2, 3, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (3, 4, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (4, 5, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (5, 1, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (6, 2, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (7, 3, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (8, 4, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (9, 5, TRUE);

INSERT INTO ProjectDeliveryEmp(ProjectID, DeliveryEmpID, onProject)
VALUES (10, 1, TRUE);


-- Technology --

INSERT INTO Technology(Name)
VALUES ('Docker');

INSERT INTO Technology(Name)
VALUES ('Kubernetes');

INSERT INTO Technology(Name)
VALUES ('AWS');

INSERT INTO Technology(Name)
VALUES ('React');

INSERT INTO Technology(Name)
VALUES ('Node.js');


-- ProjectTech

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (2, 2);  -- Project Beta uses IntelliJ IDEA

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (3, 3);  -- Project Gamma uses Docker

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (4, 4);  -- Project Delta uses Kubernetes

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (5, 5);  -- Project Epsilon uses AWS

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (6, 6);  -- Project Zeta uses React

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (7, 7);  -- Project Eta uses Node.js

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (8, 1);  -- Project Theta uses GitHub

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (9, 2);  -- Project Iota uses IntelliJ IDEA

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (10, 3); -- Project Kappa uses Docker

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (1, 4);  -- Project Alpha also uses Kubernetes

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (2, 5);  -- Project Beta also uses AWS

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (3, 6);  -- Project Gamma also uses React

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (4, 7);  -- Project Delta also uses Node.js

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (5, 1);  -- Project Epsilon also uses GitHub

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (6, 2);  -- Project Zeta also uses IntelliJ IDEA

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (7, 3);

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (8, 4);

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (9, 5);

INSERT INTO ProjectTech(ProjectID, TechID)
VALUES (10, 6);

