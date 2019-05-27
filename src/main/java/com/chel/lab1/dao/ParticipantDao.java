package com.chel.lab1.dao;

import com.chel.lab1.entities.Participant;
import com.chel.lab1.entities.Race;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class ParticipantDao implements Dao<Participant> {
    private Connector connector = new Connector();

    @Override
    public Participant get(int id) {
        String query = "SELECT * FROM participants WHERE id=" + id;
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Participant participant = new Participant(resultSet.getInt("id"), resultSet.getInt("race_id"),
                    resultSet.getInt("rider_id"), resultSet.getDouble("coeff"));
            connector.closeConnection();
            return participant;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Participant> getAll() {
        String query = "SELECT * FROM participants";
        ArrayList<Participant> participants = new ArrayList<>();
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                participants.add(new Participant(resultSet.getInt("id"), resultSet.getInt("race_id"),
                        resultSet.getInt("rider_id"), resultSet.getDouble("coeff")));
            connector.closeConnection();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return participants;
    }


    public ArrayList<Participant> getAllForRace(int id) {
        String query = "SELECT * FROM participants WHERE race_id = '" + id + "'";
        connector.createNewConnection();
        ArrayList<Participant> participants = new ArrayList<>();

        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
                participants.add(new Participant(resultSet.getInt("id"), resultSet.getInt("race_id"),
                        resultSet.getInt("rider_id"), resultSet.getDouble("coeff")));
            connector.closeConnection();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return participants;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM participants WHERE id=" + id;
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
    public void save(Participant participant) {

    }



    @Override
    public void update(int id, Map<String, String> params) {

    }


}
