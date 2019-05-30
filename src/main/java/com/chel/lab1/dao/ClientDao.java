package com.chel.lab1.dao;

import com.chel.lab1.entities.Client;
import com.chel.lab1.entities.Participant;
import com.chel.lab1.model.BetModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class ClientDao implements Dao<Client> {
    private static ClientDao instance = new ClientDao();

    private ClientDao() { };

    public static ClientDao getInstance() {
        return instance;
    }

    private static final Logger logger = Logger.getLogger(BetDao.class.getName());


    private Connector connector = new Connector();

    @Override
    public Client get(int id) {
        String query = "SELECT * FROM clients WHERE id='" + id + "'";
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Client client = new Client(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("pass"),
                    resultSet.getDouble("account"), resultSet.getString("name"));
            connector.closeConnection();
            return client;
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Iterable<Client> getAll() {
        String query = "SELECT * FROM clients";
        ArrayList<Client> clients = new ArrayList<>();
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                clients.add(new Client(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("pass"),
                        resultSet.getDouble("account"), resultSet.getString("name")));
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }
        return clients;
    }



    @Override
    public void delete(int id) {
        String query = "DELETE FROM clients WHERE id='" + id + "'";
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }
    }

    @Override
    public void save(Client client) {

    }



    @Override
    public void update(int id, Map<String, String> params) {
        String query = "UPDATE clients SET ";
        for(String key: params.keySet())
        {
            query += key + "='"+ params.get(key) + "', ";
        }
        query = query.substring(0, query.length()-2);
        query += " WHERE id='" + id + "'";
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }

    }


    public Client findByLogin(String login) {
        String query = "SELECT * FROM clients WHERE login='" + login + "'";
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Client client = new Client(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("pass"),
                    resultSet.getDouble("account"), resultSet.getString("name"));
            connector.closeConnection();
            return client;
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }
        return null;
    }

}
