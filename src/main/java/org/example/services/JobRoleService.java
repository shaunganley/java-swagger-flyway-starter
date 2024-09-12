package org.example.services;

import org.example.daos.DatabaseConnector;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.InvalidException;
import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleDetailedResponse;
import org.example.models.JobRoleRequest;
import org.example.models.JobRoleResponse;
import org.example.validators.JobRoleValidator;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    JobRoleDao jobRoleDao;
    JobRoleValidator jobRoleValidator;
    DatabaseConnector databaseConnector;

    public JobRoleService(final JobRoleDao jobRoleDao,
                          final JobRoleValidator jobRoleValidator) {
        this.jobRoleDao = jobRoleDao;
        this.jobRoleValidator = jobRoleValidator;
    }

    public int createJobRole(final JobRoleRequest jobRoleRequest)
            throws SQLException, InvalidException {
        jobRoleValidator.validateJobRole(jobRoleRequest);

        int jobRoleId = jobRoleDao.createJobRole(jobRoleRequest);
        return jobRoleId;
    }

    public List<JobRoleResponse> getOpenJobRoles(
            final String orderBy, final String direction) throws SQLException {
        return JobRoleMapper.mapJobRolesListToJobRoleResponseList(
                jobRoleDao.getOpenJobRoles(orderBy, direction));
    }

    public JobRoleDetailedResponse getJobRoleById(final int id)
        throws SQLException, DoesNotExistException {
        JobRole jobRole = jobRoleDao.getJobRoleById(id);
        if (jobRole == null) {
            throw new DoesNotExistException();
        }
        return JobRoleMapper.mapJobRoleToJobRoleDetailedResponse(jobRole);
    }
}
