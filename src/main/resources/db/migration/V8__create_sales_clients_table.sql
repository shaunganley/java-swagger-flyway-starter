-- Adding a Tech Lead to the Project
ALTER TABLE Project
ADD COLUMN TechLeadID int;

-- Foreign Key that references the DeliveryEmployee Id.
ALTER TABLE Project
ADD CONSTRAINT FK_TechLeadID
FOREIGN KEY (TechLeadID) REFERENCES DeliveryEmployee(id);

-- Realised that the 'Value' field should refer to a monetary value
-- Thankfully this is a lossless conversion (tinyint -> decimal)
ALTER TABLE Project
MODIFY COLUMN Value DECIMAL(10,2);

-- Each Client has a single sales employee, but a sales employee can work with multiple clients
-- Next we add an attribute to Client to represent the Sales Employee
ALTER TABLE Client
ADD COLUMN SalesEmployeeID int;

-- Adding a constraint here to reflect the Foreign Key of the Sales ID
ALTER TABLE Client
ADD CONSTRAINT FK_SalesEmployeeID
FOREIGN KEY (SalesEmployeeID) REFERENCES SalesEmployee(id);