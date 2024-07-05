package org.example.services;

import org.example.daos.TestDao;

import java.sql.SQLException;
import java.util.List;

public class TestService {
    private TestDao testDao;
    public TestService(final TestDao tDao) {
        this.testDao = tDao;
    }
    public List<String> testConnection() throws SQLException {
        return testDao.testConnection();
    }
}
