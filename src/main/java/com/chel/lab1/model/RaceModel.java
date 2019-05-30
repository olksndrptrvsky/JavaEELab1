package com.chel.lab1.model;


import com.chel.lab1.dao.RaceDao;
import com.chel.lab1.entities.Race;

import java.util.ArrayList;


public class RaceModel{

    private static RaceModel instance = RaceModel.getInstance();

    private RaceModel() { };

    public static RaceModel getInstance() {
        return instance;
    }


    private static RaceDao raceDao = RaceDao.getInstance();

    public Iterable<Race> getAllRaces() {
        return raceDao.getAll();
    }

    public Race getRaceById(int id) {
        return raceDao.get(id);
     }


    public void deleteRaceById(int id) {
        raceDao.delete(id);
     }

}
