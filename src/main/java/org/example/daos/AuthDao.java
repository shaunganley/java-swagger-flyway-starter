package org.example.daos;

import org.example.exceptions.DatabaseConnectionException;
import org.example.models.LoginRequest;
import org.example.models.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.util.PasswordEncoder.getPasswordEncoder;

public class AuthDao {
    private final int maxSetStringNumber = 3;

    public User getUser(final LoginRequest loginRequest)
            throws SQLException, DatabaseConnectionException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT `email`, `password`, `roleId`"
                    + "FROM `User`"
                    + "WHERE `email` = ?;";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, loginRequest.getEmail());

            ResultSet resultSet = statement.executeQuery();
            Argon2PasswordEncoder arg2SpringSecurity = getPasswordEncoder();
            while (resultSet.next()) {
                String encodedPassword =
                        resultSet.getString("password");
                if (
                        arg2SpringSecurity.matches(
                                loginRequest.getPassword(),
                                encodedPassword
                        )
                ) {
                    return new User(
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getInt("roleId")
                    );
                }
            }
        }
        return null;
    }

}
