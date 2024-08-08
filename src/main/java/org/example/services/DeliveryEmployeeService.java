package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.SQLException;

public class DeliveryEmployeeService {

    public void updateDeliveryEmployee(int id,
                                       DeliveryEmployeeRequest deliveryEmployeeRequest)
    throws SQLException {

        deliveryEmployeeValidator.validateDeliveryEmployee(deliveryEmployeeRequest);

        DeliveryEmployee deliveryEmployeeToUpdate = DeliveryEmployeeDao.getDeliveryEmployeeById(id);

        if (deliveryEmployeeToUpdate == null) {
            throw new SQLException();
        }

        DeliveryEmployeeDao.updateDeliveryEmployee(id, deliveryEmployeeRequest);

    }
}
