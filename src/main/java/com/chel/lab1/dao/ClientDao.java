package com.chel.lab1.dao;

import com.chel.lab1.entities.Client;
import com.chel.lab1.entities.Participant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class ClientDao implements Dao<Client> {
    private Connector connector = new Connector();

    @Override
    public Client get(int id) {
        String query = "SELECT * FROM clients WHERE id='" + id + "'";
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Client client = new Client(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("pass"),
                    resultSet.getDouble("account"), resultSet.getString("name"));
            connector.closeConnection();
            return client;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Client> getAll() {
        String query = "SELECT * FROM clients";
        ArrayList<Client> clients = new ArrayList<>();
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                clients.add(new Client(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("pass"),
                        resultSet.getDouble("account"), resultSet.getString("name")));
            connector.closeConnection();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return clients;
    }



    @Override
    public void delete(int id) {
        String query = "DELETE FROM clients WHERE id='" + id + "'";
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
            connector.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
            connector.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public Client findByLogin(String login) {
        String query = "SELECT * FROM clients WHERE login='" + login + "'";
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Client client = new Client(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("pass"),
                    resultSet.getDouble("account"), resultSet.getString("name"));
            connector.closeConnection();
            return client;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }



}
