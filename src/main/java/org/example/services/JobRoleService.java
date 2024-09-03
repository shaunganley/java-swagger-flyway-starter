package org.example.services;

import org.example.daos.DatabaseConnector;
import org.example.daos.JobRoleDao;
import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    JobRoleDao jobRoleDao;
    DatabaseConnector databaseConnector;

    public JobRoleService(final JobRoleDao jobRoleDao) {
        this.jobRoleDao = jobRoleDao;
    }

    public List<JobRoleResponse> getOpenJobRoles() throws SQLException {
        return JobRoleMapper.mapJobRolesListToJobRoleResponseList(
                jobRoleDao.getOpenJobRoles());
    }
    /*ADD DOES NOT EXIST EXCEPTION*/
    public JobRole getJobRoleById(final int id)
        throws SQLException {
        JobRole jobRole = jobRoleDao.getJobRoleById(id);
        return jobRole;
    }
}
