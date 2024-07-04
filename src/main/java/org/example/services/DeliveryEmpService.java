package org.example.services;


import org.example.daos.DeliveryEmpDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.DeliveryEmpRequest;

import java.sql.SQLException;

public class DeliveryEmpService {
    DeliveryEmpDao deliveryEmpDao;

    public DeliveryEmpService(DeliveryEmpDao deliveryEmpDao) {
        this.deliveryEmpDao = deliveryEmpDao;
    }

    public int createDeliveryEmployee(DeliveryEmpRequest deliveryEmpRequest)
            throws SQLException, FailedToCreateException
    {
        int id = deliveryEmpDao.createSalesEmployee(deliveryEmpRequest);
        if (id == -1) {
            throw new FailedToCreateException(Entity.DELIVERY_EMPLOYEE);
        }
        return id;
    }
}