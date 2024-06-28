package org.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnector {
    private static Connection conn;
    private DatabaseConnector() { }
    public static Connection getConnection() throws SQLException {

        if (conn != null && !conn.isClosed()) {
            return conn;
        }

        try {
            String username = System.getenv().get("RachaelMcK");
            String password = System.getenv().get("Potatohead324DB/");
            String host = System.getenv().get("jdbc:mysql:'//'academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com");
            String name = System.getenv().get("Flyway_Test_RachaelMcK");

            if (username == null || password == null || host == null
                    || name == null) {
                throw new IllegalArgumentException(
                        "Add the following properties to env vars: "
                        + "DB_USERNAME, DB_PASSWORD, DB_HOST and DB_NAME");
            }
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/" + name, username, password);
            return conn;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
