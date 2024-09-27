SELECT
    `client`.`name` AS 'Client Name',
    GROUP_CONCAT(`salesEmployees`.`firstName`, ' ', `salesEmployees`.`lastName` SEPARATOR ', ') AS 'Sales Employees',
    GROUP_CONCAT(`project`.`name` SEPARATOR ', ') AS 'Projects'
FROM `client`
         INNER JOIN `project`
                    ON `client`.`clientId` = `project`.`clientId`
         INNER JOIN `salesEmployees`
                    ON `project`.`salesEmployeeId` = `salesEmployees`.`salesEmployeeId`
GROUP BY `client`.`clientId`;