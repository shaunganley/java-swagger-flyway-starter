package org.example.services;

import org.example.daos.JobRoleDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.ResultSetException;
import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleFilteredRequest;
import org.example.models.JobRoleResponse;

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

    public List<JobRoleResponse> getFilteredJobRoles(
            final JobRoleFilteredRequest jobRoleFilteredRequest)
            throws SQLException, DoesNotExistException, ResultSetException {
        List<JobRoleResponse> jobRoleResponses = JobRoleMapper.toResponse(jobRoleDao.getFilteredJobRoles(
                jobRoleFilteredRequest));
        if (jobRoleResponses.isEmpty()) {
            throw new DoesNotExistException(Entity.JOB_ROLE);
        }
        return jobRoleResponses;
    }
}
