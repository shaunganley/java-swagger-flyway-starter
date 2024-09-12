package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.JobRoleRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class JobRoleValidator {

    private static final int JOB_ROLE_MAX_LENGTH = 50;
    private static final int JOB_ROLE_MIN_LENGTH = 5;

    public void validateJobRole(final JobRoleRequest jobRoleRequest) throws
            InvalidException {

        if (jobRoleRequest.getRoleName() == null
                || jobRoleRequest.getRoleName().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Role Name is required.");
        }
        if (jobRoleRequest.getRoleName().length() > JOB_ROLE_MAX_LENGTH) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Role Name is greater than 50 characters.");
        }
        if (jobRoleRequest.getRoleName().length() < JOB_ROLE_MIN_LENGTH) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Role Name is less than 5 characters.");
        }

        if (jobRoleRequest.getDescription() == null
                || jobRoleRequest.getDescription().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Spec Summary is required.");
        }

        if (jobRoleRequest.getSharepointUrl() == null
                || jobRoleRequest.getSharepointUrl().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Sharepoint Link is required.");
        }
        if (!validateUrl(jobRoleRequest.getSharepointUrl())) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Sharepoint Link must be a valid URL.");
        }

        if (jobRoleRequest.getResponsibilities() == null
                || jobRoleRequest.getResponsibilities().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Responsibilities are required.");
        }
        if (jobRoleRequest.getNumberOfOpenPositions() <= 0) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Number of Open Positions must be greater than 0.");
        }

        if (jobRoleRequest.getLocation() == null
                || jobRoleRequest.getLocation().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Location is required.");
        }

        if (jobRoleRequest.getClosingDate() == null) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Closing date is required.");
        }
        if (!validateClosingDate(jobRoleRequest.getClosingDate())) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Closing date cannot be in the past.");
        }

        if (jobRoleRequest.getCapabilityId() <= 0) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Capability ID must be a positive number.");
        }

        if (jobRoleRequest.getBandId() <= 0) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Band ID must be a positive number.");
        }


    }

    // Method to validate the URL format
    private boolean validateUrl(final String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    // Method to ensure the closing date is not in the past
    private boolean validateClosingDate(final Date closingDate) {
        Date today = new Date();
        today.setHours(0);
        today.setMinutes(0);
        today.setSeconds(0);

        return !closingDate.before(today);
    }
}

