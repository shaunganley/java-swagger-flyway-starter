package org.example.daos;

import org.example.models.client;
import org.example.requests.ClientRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    public int createClient(ClientRequest ClientRequest) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection()) {

            String insertStatement = "INSERT INTO `Client`(clientName, clientAddress, clientPhoneNumber)" +
                    "VALUES (?, ?, ?);";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, ClientRequest.getClientName());
            statement.setString(2, ClientRequest.getClientAddress());
            statement.setString(3, ClientRequest.getClientPhoneNumber());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
}
