package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Client;
import com.chel.lab1.entities.Participant;
import com.chel.lab1.model.ParticipantModel;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class GetParticipantsForRaceCommand implements Command {

    @Override
    public ArrayList<Participant> execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException  {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);

        ArrayList<Participant> participants = new ParticipantModel().getAllParticipantsForRace(id);

        return participants;
    }
}
