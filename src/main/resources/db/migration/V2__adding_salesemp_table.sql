create table salesEmployee(
                              salesEmpId int PRIMARY KEY AUTO_INCREMENT NOT NULL,
                              commissionRate decimal(2,2),
                              empId int);

alter table salesEmployee
    ADD CONSTRAINT fk_Emp_Id
        FOREIGN KEY(salesEmpId)
            references Employee(empId);