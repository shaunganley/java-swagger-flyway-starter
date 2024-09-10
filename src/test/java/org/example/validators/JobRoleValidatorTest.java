package org.example.validators;

import org.example.exceptions.InvalidException;
import org.example.models.JobRoleRequest;
import org.junit.jupiter.api.Test;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JobRoleValidatorTest {

    @Test
    public void validateJobRole_shouldThrowException_forEmptyRoleName() {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Job Role Name is required.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forTooShortRoleName() {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "abcd",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Job Role Name is less than 5 characters.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forTooLongRoleName() {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        String longRoleName = "A".repeat(51); // Create a role name of 51 characters
        JobRoleRequest request = new JobRoleRequest(
                longRoleName,
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Job Role Name is greater than 50 characters.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forInvalidUrl() {

        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "invalid-url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Sharepoint Link must be a valid URL.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forClosingDateInPast() {
        // Get the current time in milliseconds
        long millis = System.currentTimeMillis();

        // Calculate the milliseconds for 1 day in the past (24 hours * 60 minutes * 60 seconds * 1000 milliseconds)
        long oneDayInMillis = 24 * 60 * 60 * 1000;

        // Calculate the past date by subtracting one day from the current time
        Date pastDate = new Date(millis - oneDayInMillis);

        JobRoleRequest request = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                pastDate,
                1,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Closing date cannot be in the past.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forInvalidCapabilityIdZero() {
        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                0,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Capability ID must be a positive number.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forInvalidCapabilityIdNegative() {
        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,               // Invalid capability ID
                "Some location",
                closingDate,
                -1,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Capability ID must be a positive number.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forInvalidBandIdZero() {
        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                0
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Band ID must be a positive number.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldThrowException_forInvalidBandIdNegative() {
        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                -1
        );
        JobRoleValidator validator = new JobRoleValidator();

        InvalidException thrown = assertThrows(
                InvalidException.class,
                () -> validator.validateJobRole(request),
                "Expected validateJobRole() to throw, but it didn't"
        );

        assertEquals("JobRole is not valid: Band ID must be a positive number.", thrown.getMessage());
    }

    @Test
    public void validateJobRole_shouldNotThrowException_forValidCapabilityIdAndBandId() throws InvalidException {
        long millis = System.currentTimeMillis();
        Date closingDate = new Date(millis);

        JobRoleRequest request = new JobRoleRequest(
                "Valid Role Name",
                "Some description",
                "https://valid.url",
                "Some responsibilities",
                1,
                "Some location",
                closingDate,
                1,
                3
        );
        JobRoleValidator validator = new JobRoleValidator();

        validator.validateJobRole(request);
    }

}
