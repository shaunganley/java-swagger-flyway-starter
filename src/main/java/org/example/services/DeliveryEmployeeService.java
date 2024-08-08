package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;
import org.example.validators.DeliveryEmployeeValidator;

import java.sql.SQLException;

public class DeliveryEmployeeService {

    DeliveryEmployeeDao deliveryEmployeeDao;
    DeliveryEmployeeValidator deliveryEmployeeValidator;

    public static void updateDeliveryEmployee(
            final int id, final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws SQLException, InvalidException {

        DeliveryEmployeeValidator.validateDeliveryEmployee(
                deliveryEmployeeRequest);

        DeliveryEmployee deliveryEmployeeToUpdate =
                DeliveryEmployeeDao.getDeliveryEmployeeById(id);

        if (deliveryEmployeeToUpdate == null) {
            throw new SQLException();
        }

        DeliveryEmployeeDao.updateDeliveryEmployee(id, deliveryEmployeeRequest);

    }
}
