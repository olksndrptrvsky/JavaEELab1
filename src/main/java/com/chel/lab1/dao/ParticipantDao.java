package com.chel.lab1.dao;

import com.chel.lab1.entities.Participant;
import com.chel.lab1.entities.Race;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class ParticipantDao implements Dao<Participant> {
    private static ParticipantDao instance = new ParticipantDao();

    private ParticipantDao() { };

    public static ParticipantDao getInstance() {
        return instance;
    }

    private static final Logger logger = Logger.getLogger(BetDao.class.getName());


    private Connector connector = new Connector();

    @Override
    public Participant get(int id) {
        String query = "SELECT * FROM participants WHERE id=" + id;
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Participant participant = new Participant(resultSet.getInt("id"), resultSet.getInt("race_id"),
                    resultSet.getInt("rider_id"), resultSet.getDouble("coeff"));
            connector.closeConnection();
            return participant;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Participant> getAll() {
        String query = "SELECT * FROM participants";
        ArrayList<Participant> participants = new ArrayList<>();
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                participants.add(new Participant(resultSet.getInt("id"), resultSet.getInt("race_id"),
                        resultSet.getInt("rider_id"), resultSet.getDouble("coeff")));
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return participants;
    }


    public Iterable<Participant> getAllForRace(int id) {
        String query = "SELECT * FROM participants WHERE race_id = '" + id + "'";
        ArrayList<Participant> participants = new ArrayList<>();

        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
                participants.add(new Participant(resultSet.getInt("id"), resultSet.getInt("race_id"),
                        resultSet.getInt("rider_id"), resultSet.getDouble("coeff")));
            connector.closeConnection();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return participants;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM participants WHERE id=" + id;
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void save(Participant participant) {
    }

    @Override
    public void update(int id, Map<String, String> params) {
    }
}
