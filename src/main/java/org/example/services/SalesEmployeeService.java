package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;
import org.example.models.SalesEmployee;
import org.example.models.SalesEmployeeRequest;

import java.sql.SQLException;

public class SalesEmployeeService {

    public void updateSalesEmployee(int id,
                                       SalesEmployeeRequest salesEmployeeRequest)
            throws SQLException {

        salesEmployeeValidator.validateSalesEmployee(salesEmployeeRequest);

        SalesEmployee salesEmployeeToUpdate = SalesEmployeeDao.getSalesEmployeeById(id);

        if (salesEmployeeToUpdate == null) {
            throw new SQLException();
        }

        SalesEmployeeDao.updateSalesEmployee(id, salesEmployeeRequest);

    }
}
