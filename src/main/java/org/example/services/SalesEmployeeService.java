package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.daos.SalesEmployeeDao;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;
import org.example.models.SalesEmployee;
import org.example.models.SalesEmployeeRequest;
import org.example.validators.DeliveryEmployeeValidator;
import org.example.validators.SalesEmployeeValidator;

import java.sql.SQLException;

public class SalesEmployeeService {

    SalesEmployeeDao salesEmployeeDao;
    SalesEmployeeValidator salesEmployeeValidator;

    public static void updateSalesEmployee(int id,
                                           SalesEmployeeRequest salesEmployeeRequest)
            throws SQLException, InvalidException {

        SalesEmployeeValidator.validateSalesEmployee(salesEmployeeRequest);

        SalesEmployee salesEmployeeToUpdate = SalesEmployeeDao.getSalesEmployeeById(id);

        if (salesEmployeeToUpdate == null) {
            throw new SQLException();
        }

        SalesEmployeeDao.updateSalesEmployee(id, salesEmployeeRequest);

    }
}
