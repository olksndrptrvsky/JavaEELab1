package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Race;
import com.chel.lab1.entities.Rider;
import com.chel.lab1.model.RaceModel;
import com.chel.lab1.model.RiderModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class GetRiderByIdCommand implements Command {


    @Override
    public Rider execute(HttpServletRequest req, HttpServletResponse res) {
        String[] values = req.getRequestURI().split("[/]");
        int id = Integer.parseInt(values[3]);
        return RiderModel.getInstance().getRiderById(id);
    }
}
