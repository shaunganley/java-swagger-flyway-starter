alter table `Project`
    add column ClientId int;

alter table `Project`
    ADD CONSTRAINT fk_Project_ClientId
        FOREIGN KEY(ClientId)
         references Client(ClientId);

alter table `Client`
    add column SalesEmployee_ID int;

alter table `Client`
    ADD CONSTRAINT fk_Client_SalesEmployeeID
    FOREIGN KEY(SalesEmployee_ID)
    references SalesEmployees(SalesEmployee_ID);

