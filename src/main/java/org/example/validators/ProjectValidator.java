package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.ProjectDetailsRequest;

public class ProjectValidator {

    public void validateProject(
            final ProjectDetailsRequest projectDetailsRequest)
            throws InvalidException {
        if (projectDetailsRequest.getClientId() <= -1) {
            throw new InvalidException(Entity.PROJECT, "Client does not exist");
        }
    }
}
