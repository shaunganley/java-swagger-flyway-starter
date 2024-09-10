package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.JobRoleRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JobRoleValidator {

    public void validateJobRole(final JobRoleRequest jobRoleRequest) throws
            InvalidException {

        // Validate role name
        if (jobRoleRequest.getRoleName() == null
                || jobRoleRequest.getRoleName().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Role Name is required.");
        }
        if (jobRoleRequest.getRoleName().length() > 50) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Role Name is greater than 50 characters.");
        }
        if (jobRoleRequest.getRoleName().length() < 5) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Role Name is less than 5 characters.");
        }

        // Validate description
        if (jobRoleRequest.getDescription() == null
                || jobRoleRequest.getDescription().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Job Spec Summary is required.");
        }

        // Validate Sharepoint URL
        if (jobRoleRequest.getSharepointUrl() == null
                || jobRoleRequest.getSharepointUrl().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Sharepoint Link is required.");
        }
        if (!validateUrl(jobRoleRequest.getSharepointUrl())) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Sharepoint Link must be a valid URL.");
        }

        // Validate responsibilities
        if (jobRoleRequest.getResponsibilities() == null
                || jobRoleRequest.getResponsibilities().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Responsibilities are required.");
        }
        if (jobRoleRequest.getNumberOfOpenPositions() <= 0) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Number of Open Positions must be greater than 0.");
        }

        // Validate location
        if (jobRoleRequest.getLocation() == null
                || jobRoleRequest.getLocation().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Location is required.");
        }

        // Validate closing date
        if (jobRoleRequest.getClosingDate() == null) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Closing date is required.");
        }
        if (!validateClosingDate(jobRoleRequest.getClosingDate())) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Closing date cannot be in the past.");
        }

        /*
        // Validate band name
        if (jobRoleRequest.getBandId() == 0
                || jobRoleRequest.getBandId().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Band Name is required.");
        }

        // Validate capability name
        if (jobRoleRequest.getCapabilityName() == null
                || jobRoleRequest.getCapabilityName().isEmpty()) {
            throw new InvalidException(Entity.JOB_ROLE,
                    "Capability Name is required.");
        }
    }

         */
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

    // Method to validate human-readable date format: "DayName Day Month Year"
    private boolean validateHumanReadableDate(final String dateString) {
        // Define the expected date format
        String dateFormat = "EEEE d MMMM yyyy";
        // Example: "Monday 9 September 2024"
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        sdf.setLenient(false);

        try {
            // Parse the string into a date object
            Date date = sdf.parse(dateString);

            // Additional validation to ensure date is formatted as expected
            if (date != null) {
                // Get the day of the week name (e.g., Monday) to compare
                String expectedDayName = new SimpleDateFormat(
                        "EEEE", Locale.ENGLISH).format(date);

                // Extract the day name from the input string for comparison
                String[] dateParts = dateString.split(" ");
                String inputDayName = dateParts[0];

                if (!expectedDayName.equals(inputDayName)) {
                    return false;
                }
            }
            return true;
        } catch (ParseException e) {
            return false; // If parsing fails, the date format is invalid
        }
    }
}

