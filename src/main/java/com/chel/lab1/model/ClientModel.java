package com.chel.lab1.model;


import com.chel.lab1.dao.ClientDao;
import com.chel.lab1.dao.RaceDao;
import com.chel.lab1.entities.Client;
import com.chel.lab1.entities.Race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ClientModel {
    private static ClientDao clientDao = new ClientDao();

    public ArrayList<Client> getAllClients() {
        return clientDao.getAll();
    }

    public Client getClientById(String id) {
        return clientDao.get(Integer.parseInt(id));
     }

    public void deleteClientById(String id) {
        clientDao.delete(Integer.parseInt(id));
     }


    public void subtractFromClient(int id, double sum) {
        Client client = clientDao.get(id);
        double refreshedAccount = client.getAccount() - sum;
        Map<String, String> params = new HashMap<>();
        params.put("account", Double.toString(refreshedAccount));
        clientDao.update(id, params);
    }

    public Client validate(Client user) {
        Client client = clientDao.findByLogin(user.getLogin());
        System.out.println(client);
        if(client==null || !client.getPass().equals(user.getPass())) return null;
        return client;
    }
}
