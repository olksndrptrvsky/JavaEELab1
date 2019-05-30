package com.chel.lab1.dao;

import com.chel.lab1.entities.Race;
import com.chel.lab1.entities.Rider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class RiderDao implements Dao<Rider> {
    private static RiderDao instance = new RiderDao();

    private RiderDao() { };

    public static RiderDao getInstance() {
        return instance;
    }

    private static final Logger logger = Logger.getLogger(BetDao.class.getName());


    private Connector connector = new Connector();

    @Override
    public Rider get(int id) {
        String query = "SELECT * FROM riders WHERE id=" + id;
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Rider rider = new Rider(resultSet.getInt("id"), resultSet.getString("full_name"),
                    resultSet.getString("horse_breed"), resultSet.getInt("wins_count"));
            connector.closeConnection();
            return rider;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Rider> getAll() {
        String query = "SELECT * FROM riders";
        ArrayList<Rider> riders = new ArrayList<>();
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                riders.add(new Rider(resultSet.getInt("id"), resultSet.getString("full_name"),
                        resultSet.getString("horse_breed"), resultSet.getInt("wins_count")));
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return riders;
    }

    public ArrayList<Rider> getAllForRace(int raceId) {
        String query = "SELECT r.* FROM participants as p JOIN riders as r ON p.rider_id=r.id WHERE race_id = '"+ raceId + "'";
        ArrayList<Rider> riders = new ArrayList<>();
        try {
            connector.createNewConnection();

            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
                riders.add(new Rider(resultSet.getInt("id"), resultSet.getString("full_name"),
                        resultSet.getString("horse_breed"), resultSet.getInt("wins_count")));
            connector.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return riders;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM riders WHERE id=" + id;
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
    public void save(Rider rider) {

    }

    @Override
    public void update(int id, Map<String, String> params) {

    }


}
