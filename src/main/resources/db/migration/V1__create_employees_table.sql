

create table employees (
    employee_ID smallint Primary Key AUTO_INCREMENT NOT NULL,
    employee_name varchar(70),
    employee_salary decimal(7,2),
    employee_bankAccountNumber varchar(8),
    employee_nationalInsuranceNumber varchar(9),
    employee_commissionRate DECIMAL(2, 2),
    role_ID smallint
)