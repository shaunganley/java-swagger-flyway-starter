package org.example;

import org.example.models.SalesEmployee;
import org.example.models.SalesEmployeeResponse;

import java.util.List;

public class mappers {
    public static List<SalesEmployeeResponse>
    mapSalesEmployeeListToSalesEmployeeResponseList
            (List<SalesEmployee> salesEmployees) {
        return salesEmployees
                .stream()
                .map(salesEmployee -> new SalesEmployeeResponse(
                        salesEmployee.getEmployeeId(),
                        salesEmployee.getFirstName(),
                        salesEmployee.getLastName(),
                        salesEmployee.getCommissionRate()));
    }
}
