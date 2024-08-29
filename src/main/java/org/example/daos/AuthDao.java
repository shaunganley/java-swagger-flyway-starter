package org.example.daos;

import org.example.models.LoginRequest;
import org.example.models.User;

import java.sql.*;

import static org.example.models.PasswordEncoder.hashPassword;


public class AuthDao {

    public User getUser(final LoginRequest loginRequest)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT Email, Password, role_id FROM `User` "
                    + "WHERE Email = ? and Password = ?;";
            PreparedStatement statement = connection.prepareStatement(query);


            String haslo = loginRequest.getPassword();
            System.out.println("tutaj_____________________");
            System.out.println(haslo);
            String hashedPassword = hashPassword(haslo);
            System.out.println(hashedPassword);



            statement.setString(1, loginRequest.getEmail());
            statement.setString(2, loginRequest.getPassword());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new User(
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("role_id"));
            }
        }
        return null;
    }

}
