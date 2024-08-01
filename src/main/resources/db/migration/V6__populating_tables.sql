insert into DeliveryEmployees (DeliveryEmployee_Name, DeliveryEmployee_Salary, DeliveryEmployee_BankAccountNum, DeliveryEmployee_NationalInsuranceNum)
values ('John Black', 50000.00, '4628553203494', 'PF64H7DU8');
insert into DeliveryEmployees (DeliveryEmployee_Name, DeliveryEmployee_Salary, DeliveryEmployee_BankAccountNum, DeliveryEmployee_NationalInsuranceNum)
values ('Kathy Brown', 34000.00, '9439250275829', 'FD7G987K8');
insert into DeliveryEmployees (DeliveryEmployee_Name, DeliveryEmployee_Salary, DeliveryEmployee_BankAccountNum, DeliveryEmployee_NationalInsuranceNum)
values ('Jack Sullivan', 60000.00, '8306593668921', 'HD87H8J8H');
insert into DeliveryEmployees (DeliveryEmployee_Name, DeliveryEmployee_Salary, DeliveryEmployee_BankAccountNum, DeliveryEmployee_NationalInsuranceNum)
values ('Michael Jones', 100000.00, '3740275927403', 'KW68GY3H7');
insert into DeliveryEmployees (DeliveryEmployee_Name, DeliveryEmployee_Salary, DeliveryEmployee_BankAccountNum, DeliveryEmployee_NationalInsuranceNum)
values ('Damien White', 29000.00, '3839265026486', 'HE7H48H3J');

insert into Project (Project_ProjectName, Project_Value, Project_ListOfTechnologies)
values ('ProjectH95', 500000.00, 'Java, SQL, C#, Python');
insert into Project (Project_ProjectName, Project_Value, Project_ListOfTechnologies)
values ('ProjectO45', 3400000.00, 'Java, Maven, MariaDB, Python');
insert into Project (Project_ProjectName, Project_Value, Project_ListOfTechnologies)
values ('ProjectB788', 600000.00, 'C++, Rust, SQL, Javascript' );
insert into Project (Project_ProjectName, Project_Value, Project_ListOfTechnologies)
values ('ProjectA2122', 1000000.00, 'C++, SQL, Javascript');
insert into Project (Project_ProjectName, Project_Value, Project_ListOfTechnologies)
values ('ProjectB463', 24000.00, 'C, Java, SQL, HTML, CSS');

insert into Schedule (DeliveryEmployee_ID, Project_ProjectID, WorkingDate)
values(3, 1, now());