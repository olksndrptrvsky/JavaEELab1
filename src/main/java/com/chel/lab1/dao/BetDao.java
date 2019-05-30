package com.chel.lab1.dao;

import com.chel.lab1.controller.commands.CheckAuthorisationCommand;
import com.chel.lab1.entities.Bet;
import com.chel.lab1.entities.Client;
import com.chel.lab1.model.BetModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class BetDao implements Dao<Bet> {

    private static BetDao instance = new BetDao();

    private BetDao() { };

    public static BetDao getInstance() {
        return instance;
    }

    private static final Logger logger = Logger.getLogger(BetDao.class.getName());

    private Connector connector = new Connector();

    @Override
    public Bet get(int id) {
        String query = "SELECT * FROM bets WHERE id='" + id + "'";
        try {
            connector.createNewConnection();
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Bet bet = new Bet(resultSet.getInt(id), resultSet.getInt("client_id"), resultSet.getInt("participant_id"),
                    resultSet.getDouble("sum"), resultSet.getString("state"));
            connector.closeConnection();
            return bet;
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getMessage());
        }
        return null;
    }

    @Override
    public Iterable<Bet> getAll() {
        String query = "SELECT * FROM bets";
        ArrayList<Bet> bets = new ArrayList<>();
        try {
            connector.createNewConnection();
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                bets.add(new Bet(resultSet.getInt("id"), resultSet.getInt("client_id"), resultSet.getInt("participant_id"),
                        resultSet.getDouble("sum"), resultSet.getString("state")));
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }
        return bets;
    }



    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Bet bet) {
        String query = "INSERT into bets(client_id, participant_id, sum, state) " +
                "values ('"+bet.getClientId()+"', " +bet.getParticipantId()+", "+bet.getSum()+", '"+bet.getState()+"')";
        try {
            connector.createNewConnection();
            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }
    }



    @Override
    public void update(int id, Map<String, String> params) {
    }


    public Iterable<Bet> getAllForClient(int clientId) {
        String query = "SELECT * FROM bets WHERE client_id='"+clientId+"'";
        ArrayList<Bet> bets = new ArrayList<>();
        try {
            connector.createNewConnection();
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                bets.add(new Bet(resultSet.getInt("id"), resultSet.getInt("client_id"), resultSet.getInt("participant_id"),
                        resultSet.getDouble("sum"), resultSet.getString("state")));
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getLocalizedMessage());
        }
        return bets;
    }
}
