package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Bet;
import com.chel.lab1.entities.BetData;
import com.chel.lab1.entities.Race;
import com.chel.lab1.model.BetModel;
import com.chel.lab1.model.RaceModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetBetsDataForClientCommand implements Command {


    @Override
    public Iterable<BetData> execute(HttpServletRequest req, HttpServletResponse res) {
        String[] values = req.getRequestURI().split("[/]");
        return BetModel.getInstance().getBetsDataForClient(values[3]);

    }
}
