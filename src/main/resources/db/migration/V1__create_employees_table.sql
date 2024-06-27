

create table Employees (
    employee_ID smallint Primary Key AUTO_INCREMENT NOT NULL,
    employee_name varchar(70),
    employee_salary decimal(7,2),
    employee_bank_account_number varchar(8),
    employee_national_insurance_number varchar(9),
    employee_commission_rate DECIMAL(2, 2),
    employee_roleID smallint
)