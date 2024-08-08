package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.Connection;

public class DeliveryEmployeeDao {

    public void updateDelivery(int id, DeliveryEmployeeRequest deliveryEmployee) {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE delivery SET ";
    }
}
