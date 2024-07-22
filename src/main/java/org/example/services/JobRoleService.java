package org.example.services;

import org.example.daos.JobRoleDao;
import org.example.models.JobRole;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    JobRoleDao roleDao;

    public JobRoleService(final JobRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<JobRole> getAllRoles() throws SQLException{
        return roleDao.getAllJobRoles();
    }
}
