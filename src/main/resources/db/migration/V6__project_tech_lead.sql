ALTER TABLE project
ADD techLead int;

ALTER TABLE project
ADD FOREIGN KEY (techLead) REFERENCES delivery_employee(id);