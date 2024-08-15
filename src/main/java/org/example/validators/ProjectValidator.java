package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.ProjectDetailsRequest;

public class ProjectValidator {

    public void validateProject(
            final ProjectDetailsRequest projectDetailsRequest)
            throws InvalidException {
        if (projectDetailsRequest.getProjectName() == null) {
            throw new InvalidException(Entity.PROJECT,
                    "Project name cannot be empty");
        }
        if (projectDetailsRequest.getProjectValue() <= -1) {
            throw new InvalidException(Entity.PROJECT,
                    "Project Value must be a positive number");
        }
        if (projectDetailsRequest.getClientId() <= -1) {
            throw new InvalidException(Entity.PROJECT,
                    "Client does not exist");
        }
        if (projectDetailsRequest.getTechLead() <= -1) {
            throw new InvalidException(Entity.PROJECT,
                    "Tech Lead does not exist");
        }
    }
}
