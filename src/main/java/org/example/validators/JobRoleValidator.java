/* package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.JobRoleRequest;

public class JobRoleValidator {

    public void validateJobRole(JobRoleRequest jobRoleRequest) throws
            InvalidException {
        if (jobRoleRequest. getRoleName().length() > 50) {
            throw new InvalidException(Entity.JOB_ROLE, "Name greater than 50 characters");

            if (jobRoleRequest.getDescription(). length() > 500) {
                throw new InvalidException(Entity.JOB_ROLE, "Description greater than 500 characters");
            }
            if (jobRoleRequest.getPrice() < 10) {
                throw new InvalidException(Entity.PRODUCT, "Price less than £10");
            }
        }

} */
