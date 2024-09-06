package org.example.daos;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.example.exceptions.FileUploadException;
import org.example.exceptions.ResultSetException;
import org.example.models.JobRole;
import org.example.models.RoleApplicationResponse;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {

    private static final String BUCKET_NAME = "good-day-org-recruitment";

    public List<JobRole> getAllJobRoles() throws SQLException, ResultSetException {
        List<JobRole> jobRoles = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT jobRoleId, roleName, location, statusId, statusName, capabilityName, "
                            + "bandName, closingDate\n"
                            + "FROM job_roles\n"
                            + "INNER JOIN capability USING(capabilityId)\n"
                            + "INNER JOIN band USING(bandId)\n"
                            + "INNER JOIN status using(statusId)\n"
                            + "WHERE statusName = 'open';");

            while (resultSet.next()) {
                addJobRoleFromResultSet(jobRoles, resultSet);
            }
        }

        return jobRoles;
    }

    private void addJobRoleFromResultSet(final List<JobRole> jobRoles,
                                         final ResultSet resultSet) throws ResultSetException {
        JobRole jobRole;
        try {
            jobRole = new JobRole(resultSet.getInt("jobRoleId"),
                    resultSet.getString("roleName"),
                    resultSet.getString("location"),
                    resultSet.getString("capabilityName"),
                    resultSet.getString("bandName"),
                    resultSet.getDate("closingDate"),
                    resultSet.getString("statusName")
            );
        } catch (SQLException e) {
            throw new ResultSetException(e.getMessage());
        }

        jobRoles.add(jobRole);
    }

    public void applyForRole(final int jobRoleId,
                             final String userEmail
                             /*final InputStream fileInputStream,
                             final FormDataContentDisposition fileDetail*/) throws FileUploadException,
            URISyntaxException {

        //TODO: check fo existence of this job role
        //uploadFileToS3(jobRoleId, userEmail, fileInputStream, fileDetail);

        //TODO: Add application to a applications table
    }


    public void uploadFileToS3(/*final int jobRoleId,
                               final String userEmail,
                               final InputStream fileInputStream,
                               final FormDataContentDisposition fileDetail*/)
            throws FileUploadException, URISyntaxException {

        AmazonS3 amazonS3Client = AmazonS3Connector.getAmazonS3Client();

        /*final Class clazz = JobRoleDao.class;

        final URL resource = clazz.getClassLoader().getResource("TestBodyToS3.json");

        File f = new File(resource.toURI());*/

        amazonS3Client.putObject(BUCKET_NAME, "TestFile", "(O  <..>  O)");

        /*String fileName = "cv/" + userEmail + "/" + jobRoleId + "/" + fileDetail.getFileName();
        try {

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(fileDetail.getSize());

            amazonS3Client.putObject(BUCKET_NAME,
                    fileName,
                    fileInputStream,
                    metadata);
        } catch (SdkClientException e) {
            throw new FileUploadException();
        }*/


    }
}
