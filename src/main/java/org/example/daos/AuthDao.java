package org.example.daos;



import org.example.models.LoginRequest;
import org.example.models.RegisterRequest;
import org.example.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class AuthDao {

    public User getUser(final LoginRequest loginRequest)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT Email, Password, role_id FROM `User` "
                    + "WHERE Email = ? and Password = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

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


//    public int createUser(final RegisterRequest user)
//            throws SQLException {
//        Connection c = DatabaseConnector.getConnection();
//
//        String insertStatement = "INSERT INTO `User` (Username, "
//                + "Password, role_id) VALUES (?,?, 2);";
//
//        PreparedStatement st = c.prepareStatement(insertStatement,
//                Statement.RETURN_GENERATED_KEYS);
//
//        st.setString(1, user.getUsername());
//        st.setString(2, user.getPassword());
//
//        return st.executeUpdate();
//
//    }

}
