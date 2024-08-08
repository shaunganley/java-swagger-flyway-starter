create table DeliveryEmployee(
                                  DeliveryID int PRIMARY KEY AUTO_INCREMENT,
                                  EmployeeID int not null,
                                  FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)

);


