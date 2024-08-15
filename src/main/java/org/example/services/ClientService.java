package org.example.services;

import org.example.daos.ClientDao;
import org.example.models.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    ClientDao clientDao;

    public ClientService(final ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getAllClients() throws SQLException {
        return clientDao.getAllClients();
    }
}
