create table employee_project(
    employee_ID smallint,
    project_ID smallint,
    startDate date,
    endDate date,
    PRIMARY KEY(employee_ID, project_ID)
)