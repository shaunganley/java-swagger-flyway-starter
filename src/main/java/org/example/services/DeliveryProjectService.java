package org.example.services;

import org.example.daos.DeliveryProjectDao;
import org.example.mappers.DeliveryProjectMapper;
import org.example.models.DeliveryProjectResponse;

import java.sql.SQLException;
import java.util.List;

public class DeliveryProjectService {

    DeliveryProjectDao deliveryProjectDao;

    public List<DeliveryProjectResponse> getProjectDetails()
            throws SQLException {
        return
                DeliveryProjectMapper.
                        mapDeliveryProjectListToDeliveryProjectResponseList(
                deliveryProjectDao.getProjectDetails());
    }
}
