package com.chel.lab1.controller.commands;


import com.chel.lab1.entities.Bet;
import com.chel.lab1.entities.Client;
import com.chel.lab1.model.BetModel;
import com.chel.lab1.model.ClientModel;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateBetCommand implements Command {

    @Override
     public Integer execute(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = req.getReader().readLine()) != null) {
                stringBuilder.append(line);
            }
            Class.forName("com.google.gson.Gson");
            String json = stringBuilder.toString();
            Bet bet = new Gson().fromJson(json, Bet.class);
            System.out.println(bet);
            new BetModel().addBet(bet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
