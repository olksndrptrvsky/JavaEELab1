package com.chel.lab1.controller.commands;


import com.chel.lab1.model.RaceModel;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;


public class DeleteRaceByIdCommand implements Command {


    @Override
    public Integer execute(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);
        new RaceModel().deleteRaceById(id);
        return 0;
    }
}
