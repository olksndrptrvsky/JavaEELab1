package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Client;
import com.chel.lab1.entities.Participant;
import com.chel.lab1.model.ParticipantModel;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetParticipantsForRaceCommand implements Command {

    @Override
    public Iterable<Participant> execute(HttpServletRequest req, HttpServletResponse res) {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);
        return ParticipantModel.getInstance().getAllParticipantsForRace(id);
    }
}
