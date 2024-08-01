ALTER TABLE project
    ADD salesID int,
    ADD deliveryID int,
    ADD clientID int,
   ADD CONSTRAINT FOREIGN KEY (salesID) REFERENCES sales(salesID),
   ADD CONSTRAINT FOREIGN KEY (deliveryID) REFERENCES delivery(deliveryID),
   ADD CONSTRAINT FOREIGN KEY (clientID) REFERENCES client(clientID)

