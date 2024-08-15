package org.example.services;

import org.example.daos.ProjectDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.Project;
import org.example.models.ProjectDetailsRequest;
import org.example.validators.ProjectValidator;

import java.sql.SQLException;

public class ProjectService {
    ProjectDao projectDao;
    ProjectValidator projectValidator;
    public ProjectService(final ProjectDao projectDao,
                          final ProjectValidator projectValidator) {
        this.projectDao = projectDao;
        this.projectValidator = projectValidator;
    }

    public Project getHighestValueProject() throws SQLException {
        return projectDao.getHighestValueProject();
    }

    public int createProject(final ProjectDetailsRequest projectDetailsRequest)
            throws FailedToCreateException, SQLException,
            InvalidException {
        projectValidator.validateProject(projectDetailsRequest);
        int id = projectDao.createProject(projectDetailsRequest);

        if (id == -1) {
            throw new FailedToCreateException(Entity.PROJECT);
        }
        return id;
    }
}
