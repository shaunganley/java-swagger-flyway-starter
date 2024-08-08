CREATE TABLE tech_lead
(
    techLeadId INT AUTO_INCREMENT PRIMARY KEY,
    empId      INT,
    FOREIGN KEY (empId) REFERENCES Employee (empId)
);