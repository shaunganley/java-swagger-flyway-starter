create table Assignments (
    project_id int not null,
    emp_id int not null,
    is_working tinyint(1),
    FOREIGN KEY (project_id) REFERENCES Project(project_id),
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);