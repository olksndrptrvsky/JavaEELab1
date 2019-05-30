package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Participant;
import com.chel.lab1.entities.Race;
import com.chel.lab1.model.ParticipantModel;
import com.chel.lab1.model.RaceModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class GetParticipantByIdCommand implements Command {


    @Override
    public Participant execute(HttpServletRequest req, HttpServletResponse res) {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);

        return ParticipantModel.getInstance().getParticipantById(id);
    }
}
