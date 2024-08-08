package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;

import org.example.models.DeliveryProjectRequest;

public class DeliveryProjectValidator {
    public void validateDeliveryProject(
            final DeliveryProjectRequest deliveryProjectRequest) throws
            InvalidException {
        if (deliveryProjectRequest.getDeliveryID() <= -1) {
            throw new InvalidException(Entity.PROJECT, "Invalid delivery id");
        }
        if (deliveryProjectRequest.getProjectID() <= -1) {
            throw new InvalidException(Entity.PROJECT, "Invalid project id");
        }
    }
}
