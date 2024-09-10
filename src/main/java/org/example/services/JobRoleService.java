package org.example.services;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.example.daos.JobApplicationDao;
import org.example.daos.JobRoleDao;
import org.example.exceptions.AlreadyExistsException;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.FileNeededException;
import org.example.exceptions.FileTooBigException;
import org.example.exceptions.FileUploadException;
import org.example.exceptions.ResultSetException;
import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.example.validators.JobApplicationValidator;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    JobRoleDao jobRoleDao;
    JobApplicationDao jobApplicationDao;

    public JobRoleService(final JobRoleDao jobRoleDao,
                          final JobApplicationDao jobApplicationDao) {
        this.jobRoleDao = jobRoleDao;
        this.jobApplicationDao = jobApplicationDao;
    }

    public List<JobRole> testConnection() throws SQLException, ResultSetException {
        return jobRoleDao.getAllJobRoles();
    }

    public List<JobRoleResponse> getAllJobRoles() throws SQLException, DoesNotExistException, ResultSetException {
        List<JobRoleResponse> jobRoleResponses = JobRoleMapper.toResponse(jobRoleDao.getAllJobRoles());
        if (jobRoleResponses.isEmpty()) {
            throw new DoesNotExistException(Entity.JOB_ROLE);
        }
        return jobRoleResponses;
    }

    public void applyForRole(final int jobRoleId,
                             final String userEmail,
                             final InputStream fileInputStream
                             ) throws DoesNotExistException, SQLException, FileTooBigException,
            AlreadyExistsException, FileNeededException, IOException, FileUploadException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.addUserMetadata("jobRoleId", String.valueOf(jobRoleId));
        metadata.addUserMetadata("userEmail", userEmail);

        byte[] fileBytes = JobApplicationValidator.validateAndProduceByteArray(jobRoleDao,
                jobApplicationDao,
                jobRoleId,
                userEmail,
                fileInputStream,
                metadata);
        jobApplicationDao.applyForRole(jobRoleId, userEmail, fileBytes, metadata);
    }


}
