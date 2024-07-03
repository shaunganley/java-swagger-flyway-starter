package org.example.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    public List<String> testConnection() throws SQLException {
        List<String> databases = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SHOW DATABASES;");

            System.out.println("003 merge trest");
            while (resultSet.next()) {
                System.out.println("003 merge trest");
                databases.add(resultSet.getString("Database"));
            }
            System.out.println("003 merge trest");
        }

        return databases;
    }
}
