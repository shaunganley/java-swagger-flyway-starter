package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    /**
     * Test the connection to the database.
     * @return a list of Databases.
     * @throws SQLException if connection fails.
     */
    public List<String> testConnection() throws SQLException {
        List<String> databases = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SHOW DATABASES;");

            while (resultSet.next()) {
                databases.add(resultSet.getString("Database"));
            }
        }

        return databases;
    }
}
