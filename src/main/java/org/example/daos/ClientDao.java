package org.example.daos;

import org.example.models.Client;
import org.example.models.ProjectRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT client.id AS 'Client ID', "
                           + "salesID as 'Sales ID', project.id "
                            + "AS 'Project ID' "
                           + "FROM `client` JOIN `project` "
                           + "ON (client.id = project.clientID);");

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("Client ID"),
                        resultSet.getInt("Sales ID"),
                        new ProjectRequest(
                                resultSet.getInt("Project ID")));

                clients.add(client);
            }
            return clients;
        }
    }
}
