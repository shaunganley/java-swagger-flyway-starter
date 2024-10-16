package org.soniakbew.daos;

import org.soniakbew.models.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT clientId, name FROM `client`;"
            );

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("clientId"),
                        resultSet.getString("name")
                );
                clients.add(client);
            }
        }
        return clients;
    }
}
