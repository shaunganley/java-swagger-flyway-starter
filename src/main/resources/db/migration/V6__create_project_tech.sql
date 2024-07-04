create table Project_Tech (
	project_id smallInt not null,
    tech_id smallInt not null,
    FOREIGN KEY (project_id) REFERENCES Project(project_id),
    FOREIGN KEY (tech_id) REFERENCES Technologies(tech_id)
);