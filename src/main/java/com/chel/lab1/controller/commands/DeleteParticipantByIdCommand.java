package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Participant;
import com.chel.lab1.model.ParticipantModel;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteParticipantByIdCommand implements Command {


    @Override
    public Integer execute(HttpServletRequest req, HttpServletResponse res) {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);
        ParticipantModel.getInstance().deleteParticipantById(id);
        return 0;
    }
}
