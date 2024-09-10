package org.example.daos;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.example.models.JobApplicationStatus;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobApplicationDao {
    private static final String BUCKET_NAME = "good-day-org-recruitment";

    public void applyForRole(final int jobRoleId,
                             final String userEmail,
                             final byte[] fileBytes,
                             final ObjectMetadata metadata)
            throws SQLException, IOException {

        String key = createKey(jobRoleId, userEmail);
        uploadFileToS3(key, fileBytes, metadata);
        addJobApplication(jobRoleId, userEmail);

    }

    private byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }

    private String createKey(int jobRoleId, String userEmail) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return "applications/" + jobRoleId + "/" + userEmail + "-resume" + timestamp;
    }

    public void uploadFileToS3(final String key,
                               final byte[] fileBytes,
                               final ObjectMetadata metadata) {

        AmazonS3 amazonS3Client = AmazonS3Connector.getAmazonS3Client();
        System.out.println("file len in bytes[] " + fileBytes.length);
        amazonS3Client.putObject(BUCKET_NAME, key, new ByteArrayInputStream(fileBytes), metadata);
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
                    + JobApplicationStatus.IN_PROGRESS.getJobApplicationStatus() + ")";

            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1,jobRoleId);
            statement.setString(2,userEmail);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if(!resultSet.next()){
                throw new SQLException();
            }

        }
    }
}
