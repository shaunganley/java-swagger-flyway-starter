CREATE TABLE deliveryEmployee (
	deliveryEmployeeId int NOT NULL AUTO_INCREMENT,
	`name` varchar(50),
	salary decimal(7, 2),
	currency char(3),
	bankAccountNumber varchar(34),
	nationalInsuranceNumber varchar(9),
	PRIMARY KEY(deliveryEmployeeId)
);