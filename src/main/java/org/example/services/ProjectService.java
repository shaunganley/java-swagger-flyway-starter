package org.example.services;

import org.example.daos.ProjectDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.CompletedProjectRequest;
import org.example.validators.ProjectValidator;

import java.sql.SQLException;


public class ProjectService {

    ProjectDao projectDao;
    ProjectValidator projectValidator;

    public ProjectService(final ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public int createCompletedProject(final int projectId,
                                      final int deliveryId,
                                      final CompletedProjectRequest
                                              completedProjectRequest)
            throws
            DoesNotExistException, SQLException, InvalidException,
            FailedToCreateException {

        projectValidator.validateProject(completedProjectRequest);
        int id = projectDao.createCompletedProject(projectId, deliveryId);

        if (id == -1) {
            throw new FailedToCreateException(Entity.PROJECT);
        }
        return id;
    }
}
