package org.example.services;

import org.example.daos.ClientDao;
import org.example.daos.TestDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.requests.ClientRequest;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    ClientDao clientDao;
    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public int createClient(ClientRequest clientRequest) throws
            FailedToCreateException, SQLException {
        int id = clientDao.createClient(clientRequest);

        if (id == -1) {
            throw new FailedToCreateException(Entity.CLIENT);
        }

        return id;
    }
}
