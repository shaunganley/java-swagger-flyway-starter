create table Project (
	project_id int auto_increment not null,
    project_value decimal(12,2) not null, 
    project_name VARCHAR(50),
    project_description VARCHAR(100),
    project_status int,
    client_id smallInt not null,
    PRIMARY KEY(project_id),
    FOREIGN KEY (client_id) REFERENCES Client(client_id)
);