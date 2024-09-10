package org.example.daos;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.example.models.ApplicationStatusId;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobApplicationDao {
    private static final String BUCKET_NAME = "good-day-org-recruitment";

    public PutObjectResult applyForRole(final int jobRoleId,
                                        final String userEmail,
                                        final byte[] fileBytes,
                                        final ObjectMetadata metadata)
            throws SQLException, IOException {

        String key = createKey(jobRoleId, userEmail);
        PutObjectResult putObjectResult = uploadFileToS3(key, fileBytes, metadata);
        addJobApplication(jobRoleId, userEmail);
        return putObjectResult;
    }

    private String createKey(int jobRoleId, String userEmail) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return "applications/" + jobRoleId + "/" + userEmail + "-resume" + timestamp;
    }

    public PutObjectResult uploadFileToS3(final String key,
                                          final byte[] fileBytes,
                                          final ObjectMetadata metadata) {

        AmazonS3 amazonS3Client = AmazonS3Connector.getAmazonS3Client();
        System.out.println("file len in bytes[] " + fileBytes.length);

        PutObjectResult putObjectResult;

        putObjectResult = amazonS3Client.putObject(BUCKET_NAME, key, new ByteArrayInputStream(fileBytes), metadata);


        return putObjectResult;
    }

    public boolean existsByIdAndUserEmail(int jobRoleId, String userEmail) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT * FROM job_application WHERE Email = ? AND jobRoleId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userEmail);
            statement.setInt(2, jobRoleId);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        }
    }

    public void addJobApplication(final int jobRoleId,
                                  final String userEmail) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO job_application (Email, jobRoleId, statusApplicationId) VALUES (?,?,"
                    + ApplicationStatusId.IN_PROGRESS.getStatusId() + ")";

            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, userEmail);
            statement.setInt(2, jobRoleId);
            System.out.println(statement);
            statement.executeUpdate();
        }
    }
}
