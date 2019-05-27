package com.chel.lab1.model;


import com.chel.lab1.dao.RaceDao;
import com.chel.lab1.entities.Race;

import java.util.ArrayList;


public class RaceModel{
    private static RaceDao raceDao = new RaceDao();

    public ArrayList<Race> getAllRaces() {
        return raceDao.getAll();
    }

    public Race getRaceById(int id) {
        return raceDao.get(id);
     }


    public void deleteRaceById(int id) {
        raceDao.delete(id);
     }

}
