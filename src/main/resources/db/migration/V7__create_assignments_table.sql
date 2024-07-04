create table Assignments (
    project_id smallInt not null,
    emp_id smallInt not null,
    is_working tinyint(1),
    FOREIGN KEY (project_id) REFERENCES Project(project_id),
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);