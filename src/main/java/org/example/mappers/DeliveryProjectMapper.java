package org.example.mappers;

import org.example.models.DeliveryProject;
import org.example.models.DeliveryProjectResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class DeliveryProjectMapper {
    private DeliveryProjectMapper() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }

    public static List<DeliveryProjectResponse>
    mapDeliveryProjectListToDeliveryProjectResponseList(
            final List<DeliveryProject> deliveryProjects) {
        return deliveryProjects
                .stream()
                .map(deliveryProject -> new DeliveryProjectResponse(
                        deliveryProject.getDeliveryID(),
                        deliveryProject.getProjectID()))
                .collect(Collectors.toList());
    }
}

