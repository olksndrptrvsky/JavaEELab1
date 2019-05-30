package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Participant;
import com.chel.lab1.entities.Rider;
import com.chel.lab1.model.RiderModel;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class GetRidersForRaceCommand implements Command {

    @Override
    public ArrayList<Rider> execute(HttpServletRequest req, HttpServletResponse res) {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);
        return RiderModel.getInstance().getRidersForRace(id);

    }
}
