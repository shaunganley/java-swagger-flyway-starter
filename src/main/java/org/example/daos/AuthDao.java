package org.example.daos;


import org.example.models.LoginRequest;
import org.example.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthDao {
    DatabaseConnector databaseConnector = new DatabaseConnector();

    public User getUser(LoginRequest loginRequest) throws SQLException {
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "SELECT username, password, loginID FROM User WHERE username = ? AND password = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, loginRequest.getUsername());
            statement.setString(2, loginRequest.getPassword());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("loginID")
                );
            }
        }
        return null;
    }

    public String registerUser(User user) throws SQLException {
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "INSERT INTO User (username, password) VALUES"
                    + "(?, ?);";
            PreparedStatement ps = connection.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getString(1);
            }
            return "Failed to create";
        }
    }
}
