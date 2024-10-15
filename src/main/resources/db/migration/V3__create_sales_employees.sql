CREATE TABLE SalesEmployee (
	id int NOT NULL,
	commissionRate decimal(4,3) NOT NULL,
	CHECK (commissionRate<=1),
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES Employee(id)
);