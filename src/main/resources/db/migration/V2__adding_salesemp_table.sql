create table salesEmployee(
                               salesEmpId int PRIMARY KEY AUTO_INCREMENT NOT NULL,
                               commissionRate decimal(2,2),
                            emp_Id int
                        ADD CONSTRAINT fk_Emp_Id
        FOREIGN KEY(empId)
         references Employee(empId);

);
