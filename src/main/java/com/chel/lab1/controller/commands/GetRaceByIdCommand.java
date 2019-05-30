package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Race;
import com.chel.lab1.model.RaceModel;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetRaceByIdCommand implements Command {


    @Override
    public Race execute(HttpServletRequest req, HttpServletResponse res) {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);
        Race race = RaceModel.getInstance().getRaceById(id);
        if(race!=null)race.formatDate();
        return race;
    }
}
