alter table `Client`
add constraint fk_client_Employee_ID
foreign key (Employee_ID)
references Employee(Employee_ID);