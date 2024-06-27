create table employee_project(
    employee_ID smallint,
    project_ID smallint,
    startDate date,
    endDate date,
    isTechLead boolean,
    PRIMARY KEY(employee_ID, project_ID)
)