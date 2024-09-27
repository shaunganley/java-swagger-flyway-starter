SELECT client.name, SUM(project.value) AS totalProjectValue
FROM clientINNER JOIN project ON client.clientId = project.clientId
GROUP BY client.name
ORDER BY totalProjectValue DESC
LIMIT 1;