package org.example.services;

import org.example.daos.ProjectDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.ProjectRequest;

import java.sql.SQLException;

public class ProjectService {

    private ProjectDao projectDao;

    public ProjectService(final ProjectDao projectDao) {

            this.projectDao = projectDao;
        }

        public int createProject(final ProjectRequest projectRequest) throws
                SQLException, FailedToCreateException {
            int id = projectDao.createProject(projectRequest);
            if (id == -1) {
                throw new FailedToCreateException(Entity.SALES_EMPLOYEE);
            }
            return id;
        }

    }

