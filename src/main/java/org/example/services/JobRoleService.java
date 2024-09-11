package org.example.services;

import org.example.daos.DatabaseConnector;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DoesNotExistException;
import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleDetailedResponse;
import org.example.models.JobRoleResponse;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    JobRoleDao jobRoleDao;
    DatabaseConnector databaseConnector;

    public JobRoleService(final JobRoleDao jobRoleDao) {
        this.jobRoleDao = jobRoleDao;
    }

    public List<JobRoleResponse> getOpenJobRoles(
            final String field, final String direction) throws SQLException {
        return JobRoleMapper.mapJobRolesListToJobRoleResponseList(
                jobRoleDao.getOpenJobRoles(field, direction));
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
