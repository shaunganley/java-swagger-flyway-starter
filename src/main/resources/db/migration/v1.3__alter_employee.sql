ALTER TABLE `Employee` 
ADD CONSTRAINT fk_employee_Role_id
FOREIGN KEY(Role_ID)
REFERENCES Role(Role_ID);
