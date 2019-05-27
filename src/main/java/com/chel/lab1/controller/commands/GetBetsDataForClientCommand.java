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
    public ArrayList<BetData> execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException  {
        String[] values = req.getRequestURI().split("[/]");

//        System.out.println("we are here");
        return new BetModel().getBetsDataForClient(values[3]);

    }
}
