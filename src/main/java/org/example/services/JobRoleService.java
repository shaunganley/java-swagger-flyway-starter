package org.example.services;

import org.example.daos.DatabaseConnector;
import org.example.daos.JobRoleDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.FormatException;
import org.example.exceptions.InvalidException;
import org.example.mappers.JobRoleMapper;
import org.example.models.JobRole;
import org.example.models.JobRoleResponse;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    private final JobRoleDao roleDao;
    private final DatabaseConnector databaseConnector;

    public JobRoleService(final JobRoleDao roleDao,
                          final DatabaseConnector databaseConnector) {
        this.roleDao = roleDao;
        this.databaseConnector = databaseConnector;
    }

    public List<JobRoleResponse> getAllRoles()
            throws SQLException {
        return JobRoleMapper.mapJobRoleToJobRoleReponseList(
                roleDao.getAllJobRoles(databaseConnector.getConnection()));
    }

    public JobRole getJobRoleById(final String detailId)
            throws SQLException, FormatException,
            DoesNotExistException, InvalidException {
        try {
            int testDetailId = Integer.parseInt(detailId);
        } catch (java.lang.NumberFormatException e) {
            throw new FormatException(Entity.ROLEDETAIL);
        }

        int finalDetailId = Integer.parseInt(detailId);
        JobRole jobRole = roleDao.getJobRoleById(finalDetailId,
                databaseConnector.getConnection());

        if (finalDetailId <= 0) {
            throw new InvalidException(Entity.ROLEDETAIL);
        } else if (jobRole == null) {
            throw new DoesNotExistException(Entity.ROLEDETAIL);
        } else {
            return jobRole;
        }
    }
}
