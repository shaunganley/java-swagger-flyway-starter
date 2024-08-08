package org.example.daos;

import org.example.models.DeliveryProject;
import org.example.models.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryProjectDao {

    public List<DeliveryProject> getProjectDetails() throws SQLException {
        List<DeliveryProject> deliveryProjects = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT projectID, deliveryID, techLead as `TechLead` FROM "
                            + "`deliveryProject` JOIN `Project` ON "
                            + "(Project.id = deliveryProject.projectID);");

            while (resultSet.next()) {
                DeliveryProject deliveryProject = new DeliveryProject(
                        resultSet.getInt("projectID"),
                        resultSet.getInt("deliveryID"),
                        new Project(
                                resultSet.getInt("projectId"),
                                resultSet.getInt("clientId"),
                                resultSet.getString("TechLead"),
                                resultSet.getDouble("value"))
                );

                deliveryProjects.add(deliveryProject);
            }
        }

        return deliveryProjects;
    }
}
