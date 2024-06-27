create table Project_Tech (
	project_id int not null,
    tech_id int not null,
    FOREIGN KEY (project_id) REFERENCES Project(project_id),
    FOREIGN KEY (tech_id) REFERENCES Technologies(tech_id)
);