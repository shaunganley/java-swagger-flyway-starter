--Create Project Table

CREATE TABLE `Project` (
`Project_ID` smallint NOT NULL Primary Key,
`Name` varchar(100) NOT NULL,
`Value` Decimal (11,2) NOT NULL,
`Tech_type_ID` smallint NOT NULL,
`Client_ID` smallint NOT NULL,
`Employee_ID` smallint NOT NULL,
`Open_closed` boolean NOT NULL

);

ALTER TABLE `Project`
ADD CONSTRAINT fk_project_Tech_type_ID
FOREIGN KEY(Tech_type_ID)
REFERENCES Tech_project(Tech_type_ID)

ALTER TABLE `Project`
ADD CONSTRAINT fk_project_Client_ID
FOREIGN KEY(Client_ID)
REFERENCES Client(Client_ID)

ALTER TABLE `Project`
ADD CONSTRAINT fk_project_Employee_ID
FOREIGN KEY(Employee_ID)
REFERENCES Employee(Employee_ID)

