package org.example.services;

import org.example.daos.JobRoleDao;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {
    JobRoleDao jobRoleDao;
    public JobRoleService(final JobRoleDao jobRoleDao) {
        this.jobRoleDao = jobRoleDao;
    }
    public List<String> testConnection() throws SQLException {
        return jobRoleDao.getAllJobRoles();
    }
}
