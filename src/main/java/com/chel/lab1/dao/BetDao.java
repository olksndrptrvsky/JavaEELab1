package com.chel.lab1.dao;

import com.chel.lab1.entities.Bet;
import com.chel.lab1.entities.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class BetDao implements Dao<Bet> {
    private Connector connector = new Connector();

    @Override
    public Bet get(int id) {
        String query = "SELECT * FROM bets WHERE id='" + id + "'";
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Bet bet = new Bet(resultSet.getInt(id), resultSet.getInt("client_id"), resultSet.getInt("participant_id"),
                    resultSet.getDouble("sum"), resultSet.getString("state"));
            connector.closeConnection();
            return bet;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Bet> getAll() {
        String query = "SELECT * FROM bets";
        ArrayList<Bet> bets = new ArrayList<>();
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                bets.add(new Bet(resultSet.getInt("id"), resultSet.getInt("client_id"), resultSet.getInt("participant_id"),
                        resultSet.getDouble("sum"), resultSet.getString("state")));
            connector.closeConnection();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return bets;
    }



    @Override
    public void delete(int id) {
//        String query = "DELETE FROM bets WHERE login='" + login + "'";
//        connector.createNewConnection();
//        try {
//            Statement statement = connector.getConnection().createStatement();
//            statement.executeUpdate(query);
//            connector.closeConnection();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }

    @Override
    public void save(Bet bet) {
        String query = "INSERT into bets(client_id, participant_id, sum, state) " +
                "values ('"+bet.getClientId()+"', " +bet.getParticipantId()+", "+bet.getSum()+", '"+bet.getState()+"')";
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }



    @Override
    public void update(int id, Map<String, String> params) {

    }


    public ArrayList<Bet> getAllForClient(int clientId) {
        String query = "SELECT * FROM bets WHERE client_id='"+clientId+"'";
        ArrayList<Bet> bets = new ArrayList<>();
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                bets.add(new Bet(resultSet.getInt("id"), resultSet.getInt("client_id"), resultSet.getInt("participant_id"),
                        resultSet.getDouble("sum"), resultSet.getString("state")));
            connector.closeConnection();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return bets;
    }
}
