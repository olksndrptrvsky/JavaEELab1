package com.chel.lab1.dao;

import com.chel.lab1.entities.Race;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class RaceDao implements Dao<Race> {
    private Connector connector = new Connector();

    @Override
    public Race get(int id) {
        String query = "SELECT * FROM races WHERE id=" + id;
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Race race =  new Race(resultSet.getInt("id"), resultSet.getString("date_time"),
                    resultSet.getString("place"), resultSet.getInt("distance"), resultSet.getString("winner"));
            connector.closeConnection();
            return race;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Race> getAll() {
        String query = "SELECT * FROM races";
        ArrayList<Race> races = new ArrayList<>();
        connector.createNewConnection();
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                races.add(new Race(resultSet.getInt("id"), resultSet.getString("date_time"),
                        resultSet.getString("place"), resultSet.getInt("distance"), resultSet.getString("winner")));
            connector.closeConnection();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return races;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM races WHERE id=" + id;
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
    public void save(Race race) {

    }

    @Override
    public void update(int id, Map<String, String> params) {

    }


}
