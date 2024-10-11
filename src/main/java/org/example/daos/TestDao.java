package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    public List<String> testConnection() throws SQLException {
        List<String> databases = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            System.out.println("Retrieving database names");

            ResultSet resultSet = statement.executeQuery(
                    "SHOW DATABASES;");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("Database"));
                databases.add(resultSet.getString("Database"));
            }
            System.out.println("Finish retrieving database names");
        }

        return databases;
    }
}
