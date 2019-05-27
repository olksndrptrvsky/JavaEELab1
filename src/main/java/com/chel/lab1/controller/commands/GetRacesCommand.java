package com.chel.lab1.controller.commands;

import com.chel.lab1.entities.Race;
import com.chel.lab1.model.RaceModel;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;

public class GetRacesCommand implements Command {

    @Override
    public ArrayList<Race> execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {
        ArrayList<Race> races = new RaceModel().getAllRaces();
        for(Race race: races)
        {
            race.formatDate();
        }
        return races;

    }
}
