alter TABLE project (
   ADD FOREIGN KEY (salesID) REFERENCES sales(salesID),
   ADD FOREIGN KEY (deliveryID) REFERENCES delivery(deliveryID)
);
