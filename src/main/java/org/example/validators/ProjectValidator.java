package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.CompletedProjectRequest;

public class ProjectValidator {

    final int max = 50;
    public void validateProject(
            final CompletedProjectRequest completedProjectRequest)
            throws InvalidException {
        if (completedProjectRequest.getClientId() <= -1) {
            throw new InvalidException(Entity.PROJECT, "Invalid client id");
        }
        if (completedProjectRequest.getTechLead().length() > max) {
            throw new InvalidException(
                    Entity.PROJECT, "Tech lead name is too long");
        }
    }
}
