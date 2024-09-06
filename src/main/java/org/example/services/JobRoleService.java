package org.example.services;

import org.example.daos.JobRoleDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.FileUploadException;
import org.example.exceptions.ResultSetException;
import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;
import org.example.models.RoleApplicationResponse;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    JobRoleDao jobRoleDao;

    public JobRoleService(final JobRoleDao jobRoleDao) {
        this.jobRoleDao = jobRoleDao;
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
                             final String userEmail
                             /*final InputStream fileInputStream,
                             final FormDataContentDisposition fileDetail*/) throws FileUploadException,
            URISyntaxException {
        jobRoleDao.applyForRole(jobRoleId, userEmail/*, fileInputStream, fileDetail*/);
    }
}
