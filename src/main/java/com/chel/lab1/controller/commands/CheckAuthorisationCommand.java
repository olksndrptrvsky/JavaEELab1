package com.chel.lab1.controller.commands;


import com.chel.lab1.ApiServlet;
import com.chel.lab1.entities.Client;
import com.chel.lab1.model.ClientModel;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CheckAuthorisationCommand implements Command {
    private static final Logger logger = Logger.getLogger(CheckAuthorisationCommand.class.getName());


    @Override
     public Client execute(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = req.getReader().readLine()) != null) {
            stringBuilder.append(line);
        }
        Class.forName("com.google.gson.Gson");
        String json = stringBuilder.toString();
        Client client = new Gson().fromJson(json, Client.class);
        System.out.println(client);
        return ClientModel.getInstance().validate(client);

    }
}
